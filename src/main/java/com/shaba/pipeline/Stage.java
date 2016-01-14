package com.shaba.pipeline;

/**
 * A basic work unit in the pipeline.
 *
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */
@FunctionalInterface
public interface Stage
{

    /**
     * executes the work to be performed. The input will be read from the
     * context The output will be stored in the context
     *
     * @param context
     *            - context object which keeps shared state
     * @throws Exception
     *
     * */
    public <C extends PipelineContext> void execute( final C context );
}
