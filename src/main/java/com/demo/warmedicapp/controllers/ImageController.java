package com.demo.warmedicapp.controllers;

import com.demo.warmedicapp.entities.File;
import com.demo.warmedicapp.entities.enums.FileType;
import com.demo.warmedicapp.services.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/soldiers")
@RequiredArgsConstructor
public class ImageController {
    private final FileService fileService;

    @GetMapping("/{id}/images")
    public ResponseEntity<List<File>> getAllImagesById(@PathVariable int id) {
        return fileService.getAllFilesBySoldierIdAndType(id, FileType.IMAGE);
    }

    @PostMapping(value = "/{id}/images", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> addImagesById(@PathVariable int id,
                                              @RequestParam("images") List<MultipartFile> images) {
        return fileService.saveAllFiles(images, FileType.IMAGE, id);
    }
}
