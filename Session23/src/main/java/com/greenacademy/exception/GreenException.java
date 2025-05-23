package com.greenacademy.exception;

public class GreenException extends RuntimeException {
    private ErrorMessage errorMessage;

    public GreenException(String errorCode) {
        super(errorCode);
        this.errorMessage = ErrorMessageLoader.getErrorMessageFromDb(errorCode);
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
