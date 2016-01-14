package com.ideaimpl.patterns.pipeline.samples.numbermagic;

import com.ideaimpl.patterns.pipeline.CancellableSequentialPipeline;
import com.ideaimpl.patterns.pipeline.Pipeline;

/**
 * A sample client class to demonstrate the usage of Pipeline Pattern
 *
 * Takes an array of integers as input and does the following calculate the
 * product of all numbers Increase each value in the array by adding the product
 * sort the numbers the sorted list is returned
 *
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */
public class NumberMagicWithProduct
{
    private final Pipeline csPipeline = new CancellableSequentialPipeline();

    {
        csPipeline.addStage( new GetProductStage() );
        csPipeline.addStage( new IncreaseValueStage() );
        csPipeline.addStage( new SortStage() );
    }

    public int [] doMagic( final int [] numbers )
    {
        final NumberMagicContext nmContext = new NumberMagicContext();
        nmContext.setInput( numbers );
        csPipeline.execute( nmContext );
        return nmContext.getSortedValues();
    }

    public Pipeline getPipeline()
    {
        return csPipeline;
    }
}
