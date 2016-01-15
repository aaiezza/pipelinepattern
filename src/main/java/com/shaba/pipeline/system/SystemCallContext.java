package com.shaba.pipeline.system;

import java.util.Stack;

import com.shaba.pipeline.PipelineContextAdaptor;

public class SystemCallContext extends PipelineContextAdaptor
{
    private final String        systemPath       = System.getenv( "PATH" );

    private final Stack<String> systemCallOutput = new Stack<String>();

    public String getSystemPath()
    {
        return systemPath;
    }

    public Stack<String> getSystemCallOutputs()
    {
        return systemCallOutput;
    }

    public void addSystemCallOutput( final String output )
    {
        systemCallOutput.push( output );
    }
}
