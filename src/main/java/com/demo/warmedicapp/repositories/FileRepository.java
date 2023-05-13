package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.File;
import com.demo.warmedicapp.entities.enums.FileType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Integer> {
    List<File> findBySoldierIdAndType(Integer id, FileType type);

    void deleteBySoldierIdAndType(Integer id, FileType type);
}
