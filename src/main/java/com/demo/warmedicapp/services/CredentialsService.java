package com.demo.warmedicapp.services;

import com.demo.warmedicapp.entities.Credentials;

public interface CredentialsService {
    Credentials findCredentialsByUsername(String username);
}
