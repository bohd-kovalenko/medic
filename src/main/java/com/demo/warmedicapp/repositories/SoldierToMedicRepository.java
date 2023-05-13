package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.Soldier;
import com.demo.warmedicapp.entities.SoldierToMedic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoldierToMedicRepository extends JpaRepository<SoldierToMedic, Integer> {
    List<Soldier> findAllByMedicId(Integer id);
}
