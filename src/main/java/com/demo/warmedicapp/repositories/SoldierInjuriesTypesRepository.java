package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.SoldierInjuriesTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SoldierInjuriesTypesRepository extends JpaRepository<SoldierInjuriesTypes, Integer> {
    Optional<SoldierInjuriesTypes> findBySoldierId(Integer id);
}
