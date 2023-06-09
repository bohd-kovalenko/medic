package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.entities.Role;
import com.demo.warmedicapp.repositories.RoleRepositrory;
import com.demo.warmedicapp.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepositrory repositrory;

    @Override
    public Role findRoleByName(String name) {
        return repositrory
                .findByName(name)
                .orElseThrow(() -> new RuntimeException()); //CHANGE THE EXCEPTION.
    }
}
