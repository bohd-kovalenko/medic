package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.GeneralSoldierMedicalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface GeneralSoldierMedicalInfoRepository extends JpaRepository<GeneralSoldierMedicalInfo, Integer> {
    Optional<GeneralSoldierMedicalInfo> findBySoldierId(Integer id);
}
