package com.shaba.pipeline.samples.numbermagic;

import java.util.Arrays;

import com.shaba.pipeline.PipelineContext;
import com.shaba.pipeline.Stage;

/**
 * A sample stage class to demonstrate the usage of Pipeline Pattern
 *
 * increases the value of each of the elements in the array by adding another
 * number
 *
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */

public class IncreaseValueStage implements Stage
{
    @Override
    public void execute( final PipelineContext _context )
    {
        final NumberMagicContext context = (NumberMagicContext) _context;
        context.setIncreasedValues( Arrays.copyOf( context.getInput(), context.getInput().length ) );
        final int [] numbers = context.getIncreasedValues();
        for ( int i = 0; i < numbers.length; i++ )
            numbers[i] += context.getOffset();
    }

}
