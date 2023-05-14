package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.GeneralSoldierMedicalInfo;
import com.demo.warmedicapp.entities.SoldierInjuriesConcrete;
import com.demo.warmedicapp.entities.SoldierInjuriesTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SoldierInjuriesConcreteRepository extends JpaRepository<SoldierInjuriesConcrete, Integer> {
    Optional<SoldierInjuriesConcrete> findBySoldierId(Integer id);
}
