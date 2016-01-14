package com.ideaimpl.patterns.pipeline;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * An adaptor class for the PipelineContext interface
 *
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */

public class PipelineContextAdaptor implements PipelineContext
{

    private final List<Error> m_errors = new ArrayList<Error>();

    public void addError( final Error e )
    {
        m_errors.add( e );
    }

    @Override
    public List<Error> getErrors()
    {
        return m_errors;
    }

}
