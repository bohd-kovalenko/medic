package com.demo.warmedicapp.services;

import com.demo.warmedicapp.entities.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllFeedbacks();

    List<Note> getAllFeedbacksBySoldierId(Integer id);

    void addFeedback(Note note);
}
