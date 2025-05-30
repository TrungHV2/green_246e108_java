package com.greenacademy.exception;

public class GreenException extends RuntimeException{
    private ErrorMessage errorMessage;
    public GreenException(String errorCode) {
        super(errorCode);
        errorMessage = ErrorMessageLoader.getErrorMessage(errorCode);
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
}
