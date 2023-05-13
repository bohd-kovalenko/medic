package com.demo.warmedicapp.filters;

import com.demo.warmedicapp.entities.Credentials;
import com.demo.warmedicapp.entities.adapters.UserDetailsAdapter;
import com.demo.warmedicapp.services.CredentialsService;
import com.demo.warmedicapp.services.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

@RequiredArgsConstructor
public class JWTSecurityFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final CredentialsService credentialsService;
    @Value("${token-cookie-name}")
    private String jwtCookieName;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {
        try {
            jwtService.validateToken(findTokenInCookies(request.getCookies()));
        } catch (Exception e) {
            filterChain.doFilter(request, response);
        }
        String username = jwtService.extractUsername(findTokenInCookies(request.getCookies()));
        Credentials credentials = credentialsService.findCredentialsByUsername(username);
        UserDetails userDetails = new UserDetailsAdapter(credentials);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails,
                        credentials,
                        userDetails.getAuthorities());
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(request, response);
    }

    private String findTokenInCookies(Cookie[] cookies) {
        Cookie tokenCookie = Arrays
                .stream(cookies)
                .filter(cookie -> cookie.getName().equals(jwtCookieName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException()); //CHANGE EXCEPTION!
        return tokenCookie.getValue();
    }
}
