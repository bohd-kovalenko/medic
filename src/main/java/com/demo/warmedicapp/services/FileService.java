package com.demo.warmedicapp.services;

import com.demo.warmedicapp.entities.File;
import com.demo.warmedicapp.entities.enums.FileType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    List<File> getAllFilesBySoldierIdAndType(Integer id, FileType type);

    void saveAllFiles(List<MultipartFile> files, FileType type, Integer id);

    void deleteAllFilesBySoldierId(Integer id, FileType type);

    byte[] extractImageByUrl(String imageUrl);
}
