package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.Soldier;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoldierRepository extends JpaRepository<Soldier, Integer> {
    @EntityGraph(attributePaths = "images")
    List<Soldier> findAll();
}
