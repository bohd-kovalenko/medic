package com.demo.warmedicapp.services.impl;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.demo.warmedicapp.entities.File;
import com.demo.warmedicapp.entities.enums.FileType;
import com.demo.warmedicapp.exceptions.UnexistingSoldierException;
import com.demo.warmedicapp.repositories.FileRepository;
import com.demo.warmedicapp.repositories.SoldierRepository;
import com.demo.warmedicapp.services.FileService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private static final int SALT_LENGTH = 7;

    private final FileRepository fileRepository;

    private final SoldierRepository soldierRepository;

    private final BlobContainerClient filesContainerClient;

    @Override
    public ResponseEntity<List<File>> getAllFilesBySoldierIdAndType(Integer id, FileType type) {
        soldierRepository.findById(id).orElseThrow(() -> new UnexistingSoldierException(id));

        List<File> files = fileRepository.findBySoldierIdAndType(id, type);
        return new ResponseEntity<>(files, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<Void> saveAllFiles(List<MultipartFile> files, FileType type, Integer id) {
        soldierRepository.findById(id).orElseThrow(() -> new UnexistingSoldierException(id));

        deleteAllFilesBySoldierId(id, type);

        files.forEach(image -> saveFile(image, type, id));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private void saveFile(MultipartFile image, FileType type, Integer id) {
        BlobClient blobClient = filesContainerClient.getBlobClient(image.getName() + "-" + id + "-" + generateRandomStringSalt() + ".png");
        uploadFile(blobClient, image);
        fileRepository.save(new File(0, blobClient.getBlobUrl(), id, type));
    }

    private void uploadFile(BlobClient blobClient, MultipartFile image) {
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
    public void deleteAllFilesBySoldierId(Integer id, FileType type) {
        filesContainerClient
                .listBlobs()
                .stream()
                .filter(blobItem -> blobItem.getName().contains(id.toString()))
                .forEach(blobItem -> filesContainerClient.getBlobClient(blobItem.getName()).delete());

        fileRepository.deleteBySoldierIdAndType(id, type);
    }
}
