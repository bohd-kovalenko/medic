package com.demo.warmedicapp.services;

import com.demo.warmedicapp.payload.requests.AuthenticationRequest;
import com.demo.warmedicapp.payload.responses.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse loginUser(AuthenticationRequest request);

    void regUser(AuthenticationRequest request);
}
