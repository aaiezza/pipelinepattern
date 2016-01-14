package com.ideaimpl.patterns.pipeline.samples.numbermagic;

import java.util.Arrays;

import com.ideaimpl.patterns.pipeline.PipelineContext;
import com.ideaimpl.patterns.pipeline.Stage;

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
