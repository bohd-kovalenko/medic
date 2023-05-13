package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.services.JWTService;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JWTServiceImpl implements JWTService {
    private static final String SECRET_KEY = "S!0Q&2nF76dyoEliV*bvTYPlkp2dN4s$1@I";

    @Override
    public String generateJWT(UserDetails userDetails) {
        Date expiration = new Date();
        expiration.setTime(expiration.getTime() + 3600000L);
        return Jwts
                .builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date()).signWith(getKey(), SignatureAlgorithm.HS256)
                .setExpiration(expiration)
                .compact();
    }

    @Override
    public void validateToken(String token) {
        JwtParser parser = Jwts.parserBuilder().setSigningKey(getKey()).build();
        try {
            parser.parse(token);
        } catch (Exception e) {
            throw new RuntimeException();// CHANGE EXCEPTION!!
        }
    }

    private Key getKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
}
