package com.shaba.pipeline;

import java.util.Stack;

/**
 *
 * An adaptor class for the PipelineContext interface
 *
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */
public class PipelineContextAdaptor implements PipelineContext
{
    private final Stack<Error> errors = new Stack<Error>();

    public void addError( final Error e )
    {
        errors.push( e );
    }

    @Override
    public Stack<Error> getErrors()
    {
        return errors;
    }

}
