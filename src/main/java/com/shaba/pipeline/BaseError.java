package com.shaba.pipeline;

/**
 * An implementation of the marker error interface
 *
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 *
 */
public class BaseError implements Error
{
    private final static String    DEFAULT_ERROR_CODE = "-100";

    private final String           errorCode;
    private final String           errorDescription;
    private final RuntimeException relatedException;


    public BaseError( final String errorDescription )
    {
        this( DEFAULT_ERROR_CODE, errorDescription );
    }

    public BaseError( final String errorCode, final String errorDescription )
    {
        this( errorCode, errorDescription, new RuntimeException( String.format( "%s : %s",
            errorCode, errorDescription ) ) );
    }

    public BaseError(
        final String errorCode,
        final String errorDescription,
        final RuntimeException relatedException )
    {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.relatedException = relatedException;
    }

    /**
     *
     * @return an error code uniquely identifying an error scenario
     */
    public String getErrorCode()
    {
        return errorCode;
    }

    /**
     *
     * @return a detailed Error message describing the error scenario including
     *         any values
     */
    public String getErrorDescription()
    {
        return errorDescription;
    }

    /**
     *
     * @return an Exception object which is related to the error scenario
     */
    @Override
    public RuntimeException getRelatedException()
    {
        return relatedException;
    }
}
