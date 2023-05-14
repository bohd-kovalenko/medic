package com.demo.warmedicapp.controllers;

import com.demo.warmedicapp.payload.requests.AuthenticationRequest;
import com.demo.warmedicapp.payload.responses.AuthenticationResponse;
import com.demo.warmedicapp.services.AuthenticationService;
import com.demo.warmedicapp.services.CookieService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final CookieService cookieService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody AuthenticationRequest requestBody,
                                                            HttpServletResponse response) {
        AuthenticationResponse responseBody = authenticationService.loginUser(requestBody);
        response.addCookie(cookieService.generateCookieForToken(responseBody.getToken()));
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> regUser(@RequestBody AuthenticationRequest request) {
        authenticationService.regUser(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
