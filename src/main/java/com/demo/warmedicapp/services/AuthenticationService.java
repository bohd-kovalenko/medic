package com.demo.warmedicapp.services;

import com.demo.warmedicapp.payload.requests.AuthenticationRequest;

public interface AuthenticationService {
    String loginUser(AuthenticationRequest request);

    void regUser(AuthenticationRequest request);
}
