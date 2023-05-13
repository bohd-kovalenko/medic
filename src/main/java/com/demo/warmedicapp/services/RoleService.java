package com.demo.warmedicapp.services;

import com.demo.warmedicapp.entities.Role;

public interface RoleService {
    Role findRoleByName(String name);
}
