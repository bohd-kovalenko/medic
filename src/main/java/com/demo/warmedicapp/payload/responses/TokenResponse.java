package com.demo.warmedicapp.payload.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TokenResponse {
    private final String token;

    @JsonCreator
    public TokenResponse(@JsonProperty("auth_token") String token) {
        this.token = token;
    }
}
