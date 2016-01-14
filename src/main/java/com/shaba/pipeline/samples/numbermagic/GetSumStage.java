package com.shaba.pipeline.samples.numbermagic;

import com.shaba.pipeline.BaseError;
import com.shaba.pipeline.PipelineContext;
import com.shaba.pipeline.Stage;

/**
 * A sample stage class to demonstrate the usage of Pipeline Pattern calculates
 * the sum of all numbers in an array
 *
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 */
public class GetSumStage implements Stage
{
    @Override
    public void execute( final PipelineContext _context )
    {
        final NumberMagicContext context = (NumberMagicContext) _context;
        final int [] numbers = context.getInput();
        if ( numbers == null )
        {
            final BaseError error = new BaseError( "EMPTY_INPUT", "The input is an empty list" );
            context.addError( error );
            return;
        }
        int sum = 0;
        for ( final int number : numbers )
            sum += number;
        context.setOffset( sum );

    }
}
