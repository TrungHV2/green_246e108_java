package com.greenacademy.exception;

import lombok.Data;

@Data
public class ErrorMessage {
    private String errorCode;
    private String message;
}
