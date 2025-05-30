package com.greenacademy.model.request;

import lombok.Data;

@Data
public class TokenRequest {
    private String username;
    private String password;
}
