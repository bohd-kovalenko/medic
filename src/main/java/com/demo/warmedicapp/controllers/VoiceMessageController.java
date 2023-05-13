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
public class VoiceMessageController {
    private final FileService fileService;

    @GetMapping("/{id}/voice-messages")
    public ResponseEntity<List<File>> getAllVoiceMessagesById(@PathVariable int id) {
        return fileService.getAllFilesBySoldierIdAndType(id, FileType.VOICE_MESSAGE);
    }

    @PostMapping(value = "/{id}/voice-messages", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> addVoiceMessageById(@PathVariable int id,
                                                    @RequestParam("voice_message") List<MultipartFile> voiceMessages) {
        return fileService.saveAllFiles(voiceMessages, FileType.VOICE_MESSAGE, id);
    }
}
