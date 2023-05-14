package com.demo.warmedicapp.controllers;

import com.demo.warmedicapp.entities.File;
import com.demo.warmedicapp.entities.enums.FileType;
import com.demo.warmedicapp.services.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/soldiers")
@RequiredArgsConstructor
@CrossOrigin(value = "*", allowedHeaders = "*")
public class ImageController {
    private final FileService fileService;

    @GetMapping("/{id}/images")
    public ResponseEntity<List<File>> getAllImagesById(@PathVariable int id) {
        List<File> files = fileService.getAllFilesBySoldierIdAndType(id, FileType.IMAGE);

        return new ResponseEntity<>(files, HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/images", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> addImagesById(@PathVariable int id,
                                              @RequestParam("images") List<MultipartFile> images) {
        fileService.saveAllFiles(images, FileType.IMAGE, id);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
