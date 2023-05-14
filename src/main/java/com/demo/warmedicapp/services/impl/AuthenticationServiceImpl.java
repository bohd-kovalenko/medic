package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.entities.Credentials;
import com.demo.warmedicapp.entities.adapters.UserDetailsAdapter;
import com.demo.warmedicapp.payload.requests.AuthenticationRequest;
import com.demo.warmedicapp.payload.responses.AuthenticationResponse;
import com.demo.warmedicapp.repositories.CredentialsRepository;
import com.demo.warmedicapp.services.AuthenticationService;
import com.demo.warmedicapp.services.CredentialsService;
import com.demo.warmedicapp.services.JWTService;
import com.demo.warmedicapp.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JWTService jwtService;
    private final CredentialsService credentialsService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final CredentialsRepository repository;

    @Override
    public AuthenticationResponse loginUser(AuthenticationRequest request) {
        Credentials credentials = credentialsService
                .findCredentialsByUsername(request.getUsername());
        validatePassword(credentials, request.getPassword());
        AuthenticationResponse response = new AuthenticationResponse(credentials.getDoctor().getName(),
                credentials.getDoctor().getSurname(),
                credentials.getUsername(),
                credentials.getRole().getName(),
                credentials.getDoctor().getId());
        response.setToken(jwtService.generateJWT(new UserDetailsAdapter(credentials)));
        return response;
    }


    @Override
    public void regUser(AuthenticationRequest request) {
        Credentials credentials = new Credentials();
        credentials.setPassword(passwordEncoder.encode(request.getPassword()));
        credentials.setUsername(request.getUsername());
        credentials.setRole(roleService.findRoleByName("doctor"));
        repository.save(credentials);
    }

    private void validatePassword(Credentials credentials, String password) {
        if (!passwordEncoder.matches(password, credentials.getPassword())) {
            throw new RuntimeException(); //CHANGE EXCEPTION!!
        }
    }
}
