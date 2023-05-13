package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    List<Image> findBySoldierId(Integer id);

    void deleteBySoldierId(Integer id);
}