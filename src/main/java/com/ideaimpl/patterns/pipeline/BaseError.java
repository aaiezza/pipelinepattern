package com.ideaimpl.patterns.pipeline;

/**
 * An implementation of the marker error interface
 *
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 *
 */
public class BaseError implements Error
{

    String    m_errorCode;
    String    m_errorDescription;
    Exception m_relatedException;

    public BaseError( final String errorCode, final String errorDescription )
    {
        m_errorCode = errorCode;
        m_errorDescription = errorDescription;
    }

    public BaseError(
        final String errorCode,
        final String errorDescription,
        final Exception relatedException )
    {
        m_errorCode = errorCode;
        m_errorDescription = errorDescription;
        m_relatedException = relatedException;
    }

    /**
     *
     * @return an error code uniquely identifying an error scenario
     */
    public String getErrorCode()
    {
        return m_errorCode;
    }

    /**
     *
     * @return a detailed Error message describing the error scenario including
     *         any values
     */
    public String getErrorDescription()
    {
        return m_errorDescription;
    }

    /**
     *
     * @return an Exception object which is related to the error scenario
     */
    public Exception getRelatedException()
    {
        return m_relatedException;
    }

}
