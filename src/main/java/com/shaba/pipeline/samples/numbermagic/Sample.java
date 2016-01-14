package com.shaba.pipeline.samples.numbermagic;

/**
 *
 *
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */
public class Sample
{
    public static void main( final String [] args ) throws InterruptedException
    {
        final int [] numbers = { 25, 10, 20, 5 };

        final NumberMagicWithSum nmws = new NumberMagicWithSum();
        final NumberMagicWithProduct nmwp = new NumberMagicWithProduct();

        final int [] resultWithSum = nmws.doMagic( numbers );
        final int [] resultWithProduct = nmwp.doMagic( numbers );

        System.out.print( "Result for NumberMagicWithSum : " );
        for ( final int number : resultWithSum )
            System.out.print( number + " " );

        System.out.print( "\n\rResult for NumberMagicWithProduct : " );
        for ( final int number : resultWithProduct )
            System.out.print( number + " " );

        System.exit( 0 );
    }
}
