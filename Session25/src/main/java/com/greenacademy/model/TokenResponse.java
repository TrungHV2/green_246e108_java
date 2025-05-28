package com.greenacademy.model;

import lombok.Data;

@Data
public class TokenResponse {
    private String token;
    private long expired;
    private String type = "Bearer";
}
