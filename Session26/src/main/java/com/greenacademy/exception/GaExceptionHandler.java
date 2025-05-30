package com.greenacademy.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GaExceptionHandler {
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> handleException(final Throwable ex) {
        GreenException greenException = null;
        if (ex instanceof GreenException) {
            greenException = (GreenException) ex;
        } else {
            greenException = new GreenException(ErrorCode.SYSTEM_ERROR);
        }
        return new ResponseEntity<>(greenException.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
