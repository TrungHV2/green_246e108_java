package com.greenacademy.api;

import com.greenacademy.model.request.TokenRequest;
import com.greenacademy.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AuthorizeApi {
    private final AuthenticationService authenticationService;

    @PostMapping("/token")
    public ResponseEntity<?> token(@RequestBody TokenRequest tokenRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(tokenRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody TokenRequest tokenRequest) {
        return ResponseEntity.ok(authenticationService.refresh(tokenRequest));
    }
}
