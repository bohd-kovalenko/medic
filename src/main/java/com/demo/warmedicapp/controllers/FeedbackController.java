package com.demo.warmedicapp.controllers;

import com.demo.warmedicapp.entities.Feedback;
import com.demo.warmedicapp.entities.Note;
import com.demo.warmedicapp.services.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soldiers")
@RequiredArgsConstructor
@CrossOrigin(value = "*", allowedHeaders = "*")
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();

        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @GetMapping("/{id}/feedbacks")
    public ResponseEntity<List<Feedback>> getAllNotesBySoldierId(@PathVariable int id) {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacksBySoldierId(id);

        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @PostMapping("/feedbacks")
    public ResponseEntity<List<Note>> addNote(@RequestBody Feedback feedback) {
        feedbackService.addFeedback(feedback);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
