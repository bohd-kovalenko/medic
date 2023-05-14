package com.demo.warmedicapp.controllers;

import com.demo.warmedicapp.entities.Note;
import com.demo.warmedicapp.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soldiers")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllFeedbacks();

        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/{id}/notes")
    public ResponseEntity<List<Note>> getAllNotesBySoldierId(@PathVariable int id) {
        List<Note> notes = noteService.getAllFeedbacksBySoldierId(id);

        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @PostMapping("/notes")
    public ResponseEntity<List<Note>> addNote(@RequestBody Note note) {
        noteService.addFeedback(note);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
