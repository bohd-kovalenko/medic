package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicRepository extends JpaRepository<Doctor, Integer> {
    @Override
    List<Doctor> findAllById(Iterable<Integer> integers);

    @Override
    Optional<Doctor> findById(Integer id);
}
