package com.demo.warmedicapp.payload.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AuthenticationRequest {
    private final String username;
    private final String password;

    @JsonCreator
    public AuthenticationRequest(@JsonProperty("username") String username,@JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }
}
