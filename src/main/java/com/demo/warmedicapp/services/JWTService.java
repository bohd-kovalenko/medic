package com.demo.warmedicapp.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String generateJWT(UserDetails userDetails);

    void validateToken(String token);

    String extractUsername(String token);
}
