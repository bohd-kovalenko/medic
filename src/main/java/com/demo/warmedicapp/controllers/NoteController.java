package com.demo.warmedicapp.controllers;

import com.azure.core.annotation.Put;
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
        List<Note> notes = noteService.getAllNotes();

        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/{id}/notes")
    public ResponseEntity<List<Note>> getAllNotesBySoldierId(@PathVariable int id) {
        List<Note> notes = noteService.getAllNotesBySoldierId(id);

        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @PostMapping("/notes")
    public ResponseEntity<Void> addNote(@RequestBody Note note) {
        noteService.addNote(note);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<Void> getAllNotesBySoldierId(@PathVariable int id,
                                                       @RequestBody Note note) {
        noteService.updateNote(id, note);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
