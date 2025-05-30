package com.greenacademy.service;

import com.greenacademy.model.request.TokenRequest;
import com.greenacademy.model.response.TokenResponse;

public interface AuthenticationService {
    TokenResponse authenticate(TokenRequest tokenRequest);
    TokenResponse refresh(TokenRequest tokenRequest);
}
