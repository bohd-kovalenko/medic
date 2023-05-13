package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.Credentials;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialsRepository extends JpaRepository<Credentials, Integer> {
    @EntityGraph(attributePaths = {"role"})
    Optional<Credentials> findByUsername(String username);
}
