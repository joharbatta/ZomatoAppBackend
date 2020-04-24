package com.upgrad.FoodOrderingApp.service.common;


import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.MessageFormat;

public class UnexpectedException extends RuntimeException {

    private static final long serialVersionUID = 2737472949025937415L;

    private final ErrorCode errorCode;

    private Throwable cause;

    private final Object[] parameters;

    public UnexpectedException(final ErrorCode errorCode, final Object... parameters) {
        super();
        this.errorCode = errorCode;
        this.parameters = parameters;
    }

    public UnexpectedException(final ErrorCode errorCode, final Throwable cause, final Object... parameters) {
        super();
        this.errorCode = errorCode;
        this.cause = cause;
        this.parameters = parameters;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return MessageFormat.format(errorCode.getDefaultMessage(), this.parameters);
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    @Override
    public final void printStackTrace(final PrintStream stream) {
        super.printStackTrace(stream);
    }

    @Override
    public final void printStackTrace(final PrintWriter writer) {
        super.printStackTrace(writer);
    }

}