package com.shaba.pipeline.samples.system;

import java.io.File;
import java.util.Stack;

import com.shaba.pipeline.CancellableSequentialPipeline;
import com.shaba.pipeline.Pipeline;
import com.shaba.pipeline.system.SystemCallContext;
import com.shaba.pipeline.system.SystemCallStage;

public class HelloWorldSystemCall
{
    private final Pipeline csPipeline = new CancellableSequentialPipeline();

    {
        csPipeline.addStage( new SystemCallStage( new File( "C:/" ), "ls", "-lA", "-h" ) );
        csPipeline.addStage( new SystemCallStage( "echo", "Hello World!" ) );
    }

    public Stack<String> run() throws Exception
    {
        final SystemCallContext context = new SystemCallContext();
        csPipeline.execute( context );
        return context.getSystemCallOutputs();
    }

    public Pipeline getPipeline()
    {
        return csPipeline;
    }
}
