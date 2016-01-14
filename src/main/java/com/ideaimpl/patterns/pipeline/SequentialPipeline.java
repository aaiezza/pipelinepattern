package com.ideaimpl.patterns.pipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * The sequential pipeline executes the stage sequence imitating a try catch
 * finally block. try { execute stages } catch (any error){ execute error stages
 * } finally { execute finally stages }
 *
 * Please note that
 *
 * @author Benoy Antony (benoy@ideaimpl.com)(http://www.ideaimpl.com)
 *
 *         Modified by Siddhu Warrier (siddhu.warrier@cloudreach.co.uk)
 *         (http://www.cloudreach.co.uk)
 *
 */
public class SequentialPipeline implements Pipeline
{

    private final List<Stage> m_stages      = new ArrayList<Stage>();
    private final List<Stage> m_errorStages = new ArrayList<Stage>();
    private final List<Stage> m_finalStages = new ArrayList<Stage>();

    private boolean           isFinished;

    @Override
    public void addErrorStage( final Stage stage )
    {
        m_errorStages.add( stage );
    }

    @Override
    public void addFinalStage( final Stage stage )
    {
        m_finalStages.add( stage );

    }

    @Override
    public void addStage( final Stage stage )
    {
        m_stages.add( stage );

    }

    @Override
    public void cancelExecution()
    {
        System.err.println( "Cancellation not supported..." );
    }

    @Override
    public void execute( final PipelineContext context )
    {
        isFinished = false;
        /* execute the stages */
        for ( final Stage stage : m_stages )
        {

            stage.execute( context );

            if ( context.getErrors() != null && !context.getErrors().isEmpty() )
                break;

        }
        /* if any error occurred, execute the error stages */
        if ( context.getErrors() != null && !context.getErrors().isEmpty() )
            for ( final Stage errorStage : m_errorStages )
                errorStage.execute( context );
        // execute the final stages
        for ( final Stage finalStage : m_finalStages )
            finalStage.execute( context );

        isFinished = true;
    }

    @Override
    public boolean isCancelled()
    {
        System.err.println( "Cancellation not supported..." );
        return false;
    }

    @Override
    public boolean isFinished()
    {
        return isFinished;
    }

}
