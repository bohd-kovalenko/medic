package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicRepository extends JpaRepository<Medic, Integer> {
    @Override
    List<Medic> findAllById(Iterable<Integer> integers);

    @Override
    Optional<Medic> findById(Integer id);
}
