package com.demo.warmedicapp.services.impl;


import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.demo.warmedicapp.entities.Image;
import com.demo.warmedicapp.repositories.ImageRepository;
import com.demo.warmedicapp.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private static final int SALT_LENGTH = 7;

    private final ImageRepository imageRepository;

    private final BlobContainerClient imageContainerClient;

    @Override
    public List<Image> getAllImagesBySoldierId(Integer id) {
        return imageRepository.findBySoldierId(id);
    }

    @Override
    public void saveAllImages(List<MultipartFile> images, Integer id) {
        images.forEach(image -> saveImage(image, id));
    }

    private void saveImage(MultipartFile image, Integer id) {
        BlobClient blobClient = imageContainerClient.getBlobClient(image.getName() + "-" + id + "-" + generateRandomStringSalt() + ".png");
        uploadImage(blobClient, image);
        imageRepository.save(new Image(0, blobClient.getBlobUrl(), id));
    }

    private void uploadImage(BlobClient blobClient, MultipartFile image) {
        try {
            blobClient.upload(image.getInputStream(), image.getSize(), true);
        } catch (IOException e) {
            throw new RuntimeException("Something is wrong with image");
        }
    }

    private String generateRandomStringSalt() {
        Random random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < SALT_LENGTH; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    @Override
    @Transactional
    public void deleteAllImagesBySoldierId(Integer id) {
        imageContainerClient
                .listBlobs()
                .stream()
                .filter(blobItem -> blobItem.getName().contains(id.toString()))
                .forEach(blobItem -> imageContainerClient.getBlobClient(blobItem.getName()).delete());

        imageRepository.deleteBySoldierId(id);
    }
}