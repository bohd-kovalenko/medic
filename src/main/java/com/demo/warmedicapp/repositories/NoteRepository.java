package com.demo.warmedicapp.repositories;

import com.demo.warmedicapp.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findBySoldierId(Integer id);
}
