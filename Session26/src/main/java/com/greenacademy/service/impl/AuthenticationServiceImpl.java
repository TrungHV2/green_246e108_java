package com.greenacademy.service.impl;

import com.greenacademy.config.JwtUtils;
import com.greenacademy.exception.ErrorCode;
import com.greenacademy.exception.GreenException;
import com.greenacademy.model.UserAdapter;
import com.greenacademy.model.request.TokenRequest;
import com.greenacademy.model.response.TokenResponse;
import com.greenacademy.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Override
    public TokenResponse authenticate(TokenRequest tokenRequest) {
        LOGGER.info("[START] AuthenticationServiceImpl authenticate request={}", tokenRequest);
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(tokenRequest.getUsername(), tokenRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserAdapter userAdapter = (UserAdapter) authentication.getPrincipal();

            TokenResponse response = new TokenResponse();
            response.setToken(jwtUtils.generateToken(userAdapter.getUsername()));
            response.setRefreshToken(jwtUtils.generateRefreshToken(userAdapter.getUsername()));
            response.setExpireTime(new Date().getTime() + jwtUtils.getExpiration());
            LOGGER.info("[END] AuthenticationServiceImpl authenticate response={}", response);
            return response;
        } catch (Exception e) {
            LOGGER.error("[EXCEPTION] AuthenticationServiceImpl authenticate with ex: {0}", e);
            throw new GreenException(ErrorCode.SYSTEM_ERROR);
        }
    }

    @Override
    public TokenResponse refresh(TokenRequest tokenRequest) {
        return null;
    }
}
