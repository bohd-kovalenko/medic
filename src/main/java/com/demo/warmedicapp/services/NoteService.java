package com.demo.warmedicapp.services;

import com.demo.warmedicapp.entities.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();

    List<Note> getAllNotesBySoldierId(Integer id);

    void addNote(Note note);

    void updateNote(Integer id, Note note);
}
