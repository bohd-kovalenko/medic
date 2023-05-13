package com.demo.warmedicapp.controllers;

import com.demo.warmedicapp.payload.requests.AuthenticationRequest;
import com.demo.warmedicapp.services.AuthenticationService;
import com.demo.warmedicapp.services.CookieService;
import jakarta.servlet.http.HttpServletResponse;
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
    private final CookieService cookieService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> loginUser(@RequestBody AuthenticationRequest requestBody,
                                          HttpServletResponse response) {
        String token = authenticationService.loginUser(requestBody);
        response.addCookie(cookieService.generateCookieForToken(token));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
