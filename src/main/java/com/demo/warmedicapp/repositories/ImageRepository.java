package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    List<Image> findBySoldierId(Integer id);

    void deleteBySoldierId(Integer id);
}
