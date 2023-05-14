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
public class VoiceMessageController {
    private final FileService fileService;

    @GetMapping("/{id}/voice-messages")
    public ResponseEntity<List<File>> getAllVoiceMessagesById(@PathVariable int id) {
        List<File> files = fileService.getAllFilesBySoldierIdAndType(id, FileType.VOICE_MESSAGE);

        return new ResponseEntity<>(files, HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/voice-messages", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> addVoiceMessageById(@PathVariable int id,
                                                    @RequestParam("voice_message") List<MultipartFile> voiceMessages) {
        fileService.saveAllFiles(voiceMessages, FileType.VOICE_MESSAGE, id);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
