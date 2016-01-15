package com.shaba.pipeline;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The sequential pipeline executes the stage sequence imitating a try catch
 * finally block. try { execute stages } catch (any error){ execute error stages
 * } finally { execute finally stages }
 *
 * Please note that
 *
 * @author Siddhu Warrier (siddhu.warrier@cloudreach.co.uk
 *         (http://www.cloudreach.co.uk) (modified original code by Benoy Antony
 *         (benoy@ideaimpl.com)(http://www.ideaimpl.com))
 *
 *
 */
public class CancellableSequentialPipeline implements Pipeline
{
    public final static int      NUM_PARALLEL_THREADS = 1;

    protected final Queue<Stage> stages               = new LinkedBlockingQueue<Stage>();
    protected final Queue<Stage> errorStages          = new LinkedBlockingQueue<Stage>();
    protected final Queue<Stage> finalStages          = new LinkedBlockingQueue<Stage>();

    protected volatile boolean   isCancelled;
    protected volatile boolean   isFinished;

    protected ExecutorService    executor;

    @Override
    public void addErrorStage( final Stage stage )
    {
        errorStages.add( stage );
    }

    @Override
    public void addFinalStage( final Stage stage )
    {
        finalStages.add( stage );
    }

    @Override
    public void addStage( final Stage stage )
    {
        stages.add( stage );
    }

    @Override
    public void cancelExecution()
    {
        if ( executor != null )
        {
            isCancelled = true;
            executor.shutdownNow();
        }
    }

    @Override
    public void execute( final PipelineContext context ) throws Exception
    {
        executor = Executors.newFixedThreadPool( NUM_PARALLEL_THREADS );
        executor.execute( ( ) -> {
            isFinished = false;
            /* execute the stages */
            for ( final Stage stage : stages )
            {
                try
                {
                    stage.execute( context );
                } catch ( Exception e )
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                if ( isCancelled || context.getErrors() != null && !context.getErrors().isEmpty() )
                    break;
            }

            if ( !isCancelled )
            {
                /* if any error occurred, execute the error stages */
                if ( context.getErrors() != null && !context.getErrors().isEmpty() )
                    for ( final Stage errorStage : errorStages )
                        try
                        {
                            errorStage.execute( context );
                        } catch ( Exception e1 )
                        {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }


                // execute the final stages
                for ( final Stage finalStage : finalStages )
                    try
                    {
                        finalStage.execute( context );
                    } catch ( Exception e )
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
            }

            isFinished = true;
            synchronized ( CancellableSequentialPipeline.this )
            {
                // notify all waiting threads
                CancellableSequentialPipeline.this.notifyAll();
            }
        } );

        while ( !isFinished() )
        {}

        if ( context.getErrors() != null && !context.getErrors().isEmpty() && errorStages.isEmpty() )
            throw context.getErrors().peek().getRelatedException();
    }

    @Override
    public boolean isCancelled()
    {
        return isCancelled;
    }

    @Override
    public boolean isFinished()
    {
        return isFinished;
    }
}
