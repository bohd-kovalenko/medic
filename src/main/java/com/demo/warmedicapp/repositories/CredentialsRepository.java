package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<Credentials, Integer> {

}
