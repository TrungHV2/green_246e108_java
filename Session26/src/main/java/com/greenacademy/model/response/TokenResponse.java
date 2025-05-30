package com.greenacademy.model.response;

import lombok.Data;

@Data
public class TokenResponse {
    private String token;
    private String refreshToken;
    private long expireTime;
}
