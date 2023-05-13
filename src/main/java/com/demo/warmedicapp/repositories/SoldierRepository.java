package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SoldierRepository extends JpaRepository<Soldier, Integer> {
    Optional<Soldier> findById(Integer id);
}
