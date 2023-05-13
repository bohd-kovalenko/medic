package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.entities.Credentials;
import com.demo.warmedicapp.entities.adapters.UserDetailsAdapter;
import com.demo.warmedicapp.payload.requests.AuthenticationRequest;
import com.demo.warmedicapp.services.AuthenticationService;
import com.demo.warmedicapp.services.CredentialsService;
import com.demo.warmedicapp.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JWTService jwtService;
    private final CredentialsService credentialsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String loginUser(AuthenticationRequest request) {
        Credentials credentials = credentialsService
                .findCredentialsByUsername(request.getUsername());
        validatePassword(credentials, request.getPassword());
        return jwtService.generateJWT(new UserDetailsAdapter(credentials));
    }

    private void validatePassword(Credentials credentials, String password) {
        if (!passwordEncoder.encode(password).equals(credentials.getPassword())) {
            throw new RuntimeException(); //CHANGE EXCEPTION!!
        }
    }
}
