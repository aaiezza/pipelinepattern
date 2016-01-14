package com.shaba.pipeline.samples.numbermagic;

import com.shaba.pipeline.PipelineContextAdaptor;

/**
 * A sample PipelineContext to demonstarte the usage of Pipeline Pattern
 *
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */
public class NumberMagicContext extends PipelineContextAdaptor
{
    private int [] input;
    private int    offset;
    private int [] increasedValues;
    private int [] sortedValues;

    public int [] getIncreasedValues()
    {
        return increasedValues;
    }

    public int [] getInput()
    {
        return input;
    }

    public int getOffset()
    {
        return offset;
    }

    public int [] getSortedValues()
    {
        return sortedValues;
    }

    public void setIncreasedValues( final int [] increasedValues )
    {
        this.increasedValues = increasedValues;
    }

    public void setInput( final int [] input )
    {
        this.input = input;
    }

    public void setOffset( final int multiplicator )
    {
        offset = multiplicator;
    }

    public void setSortedValues( final int [] sortedValues )
    {
        this.sortedValues = sortedValues;
    }
}
