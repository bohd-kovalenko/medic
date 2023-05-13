package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepositrory extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
