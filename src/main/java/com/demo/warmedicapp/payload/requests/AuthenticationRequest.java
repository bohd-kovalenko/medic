package com.demo.warmedicapp.payload.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class AuthenticationRequest {
    private final String username;
    private final String password;

    @JsonCreator
    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
