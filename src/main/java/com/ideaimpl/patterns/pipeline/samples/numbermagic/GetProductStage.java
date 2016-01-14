package com.ideaimpl.patterns.pipeline.samples.numbermagic;

import com.ideaimpl.patterns.pipeline.BaseError;
import com.ideaimpl.patterns.pipeline.PipelineContext;
import com.ideaimpl.patterns.pipeline.Stage;

/**
 * A sample stage class to demonstrate the usage of Pipeline Pattern
 *
 * calculates the product of all numbers in array
 *
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 *
 */

public class GetProductStage implements Stage
{

    @Override
    public void execute( final PipelineContext context )
    {
        final NumberMagicContext nmContext = (NumberMagicContext) context;
        final int [] numbers = nmContext.getInput();
        if ( numbers == null )
        {
            final BaseError error = new BaseError( "EMPTY_INPUT", "The input is an empty list",
                    null );
            nmContext.addError( error );
        }
        int product = 1;
        for ( final int number : numbers )
            product *= number;
        nmContext.setOffset( product );
    }

}
