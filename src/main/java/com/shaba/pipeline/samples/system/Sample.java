package com.shaba.pipeline.samples.system;

public class Sample
{
    public static void main( String [] args ) throws Exception
    {
        final HelloWorldSystemCall hello = new HelloWorldSystemCall();

        System.out.println( hello.run() );

        System.exit( 0 );
    }
}
