package com.demo.warmedicapp.entities.adapters;

import com.demo.warmedicapp.entities.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public class GrantedAuthorityAdapter implements GrantedAuthority {
    private final Role role;

    @Override
    public String getAuthority() {
        return Integer.toString(role.getId());
    }
}
