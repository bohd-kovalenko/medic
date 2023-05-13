package com.demo.warmedicapp.services;

import com.demo.warmedicapp.entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    List<Image> getAllImagesBySoldierId(Integer id);

    void saveAllImages(List<MultipartFile> images, Integer id);

    void deleteAllImagesBySoldierId(Integer id);
}
