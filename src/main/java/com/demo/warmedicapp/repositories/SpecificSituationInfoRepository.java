package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.SpecificSituationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecificSituationInfoRepository extends JpaRepository<SpecificSituationInfo, Integer> {
    Optional<SpecificSituationInfo> findBySoldierId(Integer id);
}
