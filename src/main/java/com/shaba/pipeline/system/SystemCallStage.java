package com.shaba.pipeline.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.shaba.pipeline.BaseError;
import com.shaba.pipeline.PipelineContext;
import com.shaba.pipeline.Stage;

public class SystemCallStage implements Stage
{
    private final Runtime   runtime = java.lang.Runtime.getRuntime();

    private final File      activeDirectory;
    private final String    command;

    private final String [] args;

    public SystemCallStage( final String command, final String... args )
    {
        this( new File( "." ), command, args );
    }

    public SystemCallStage( final File activeDirectory, final String command, final String... args )
    {
        this.activeDirectory = activeDirectory;
        this.command = command;
        this.args = args;
    }

    @Override
    public void execute( final PipelineContext context ) throws InterruptedException
    {
        final SystemCallContext scContext = (SystemCallContext) context;

        final StringBuilder com = new StringBuilder( command );
        for ( final String arg : args )
            com.append( " " ).append( arg );

        try
        {
            final Process process = runtime
                    .exec( com.toString(), new String [] {}, activeDirectory );

            final StringBuilder output = new StringBuilder();

            process.waitFor();
            final BufferedReader reader = new BufferedReader( new InputStreamReader(
                    process.getInputStream() ) );
            // And print each line
            String line = null;
            while ( ( line = reader.readLine() ) != null )
            {
                output.append( line ).append( "\n" );
            }
            reader.close();

            scContext.addSystemCallOutput( output.toString() );
        } catch ( final IOException e )
        {
            scContext.addError( new BaseError( "Issue with reading the process's output", e ) );
        }
    }
}
