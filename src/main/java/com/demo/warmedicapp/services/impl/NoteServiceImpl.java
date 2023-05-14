package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.entities.Note;
import com.demo.warmedicapp.exceptions.UnexistingSoldierException;
import com.demo.warmedicapp.exceptions.ValidationException;
import com.demo.warmedicapp.repositories.NoteRepository;
import com.demo.warmedicapp.services.NoteService;
import com.demo.warmedicapp.services.SoldierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    private final SoldierService soldierService;

    public List<Note> getAllFeedbacks() {
        return noteRepository.findAll();
    }

    public List<Note> getAllFeedbacksBySoldierId(Integer id) {
        List<Note> notes;

        try {
            notes = noteRepository.findBySoldierId(id);
        } catch (Exception e) {
            throw new UnexistingSoldierException(id);
        }

        return notes;
    }

    public void addFeedback(Note note) {
        soldierService.getSoldierById(note.getSoldierId());

        try {
            noteRepository.save(note);
        } catch (Exception e) {
            throw new ValidationException();
        }
    }
}
