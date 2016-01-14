package com.ideaimpl.patterns.pipeline.samples.numbermagic;

/**
 *
 *
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */
public class Sample
{

    public static void main( final String [] args )
    {
        final int [] numbers = { 25, 10, 20, 5 };


        final int [] resultWithSum = new NumberMagicWithSum().doMagic( numbers );

        System.out.print( "Result for NumberMagicWithSum :" );

        for ( final int number : resultWithSum )
            System.out.print( number + " " );


        final int [] resultWithProduct = new NumberMagicWithProduct().doMagic( numbers );

        System.out.print( "\n\rResult for NumberMagicWithProduct :" );
        for ( final int number : resultWithProduct )
            System.out.print( number + " " );


    }

}
