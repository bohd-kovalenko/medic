package com.demo.warmedicapp.controllers;

import com.demo.warmedicapp.payload.requests.AuthenticationRequest;
import com.demo.warmedicapp.payload.responses.TokenResponse;
import com.demo.warmedicapp.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TokenResponse> loginUser(@RequestBody AuthenticationRequest requestBody) {
        String token = authenticationService.loginUser(requestBody);
        return new ResponseEntity<>(new TokenResponse(token), HttpStatus.OK);
    }
}
