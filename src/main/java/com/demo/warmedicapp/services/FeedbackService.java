package com.demo.warmedicapp.services;

import com.demo.warmedicapp.entities.Feedback;
import com.demo.warmedicapp.entities.Note;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getAllFeedbacks();

    List<Feedback> getAllFeedbacksBySoldierId(Integer id);

    void addFeedback(Feedback feedback);
}
