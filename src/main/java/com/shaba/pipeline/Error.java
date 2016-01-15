package com.shaba.pipeline;

/**
 *
 * A marker Error interface
 *
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */
public interface Error
{
    /**
     *
     * @return an Exception object which is related to the error scenario
     */
    public Exception getRelatedException();
}
