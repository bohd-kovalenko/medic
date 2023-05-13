package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.entities.adapters.UserDetailsAdapter;
import com.demo.warmedicapp.services.CredentialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final CredentialsService credentialsService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetailsAdapter(credentialsService.findCredentialsByUsername(username));
    }
}
