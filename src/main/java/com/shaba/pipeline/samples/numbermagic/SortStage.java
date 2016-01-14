package com.shaba.pipeline.samples.numbermagic;

import java.util.Arrays;

import com.shaba.pipeline.PipelineContext;
import com.shaba.pipeline.Stage;

/**
 * A sample Stage class to demonstrate the usage of Pipeline Pattern
 *
 * sorts an array of numbers
 *
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */
public class SortStage implements Stage
{
    @Override
    public void execute( final PipelineContext _context )
    {
        final NumberMagicContext context = (NumberMagicContext) _context;
        final int [] sortedValues = Arrays.copyOf( context.getIncreasedValues(),
            context.getIncreasedValues().length );
        Arrays.sort( sortedValues );
        context.setSortedValues( sortedValues );
    }
}
