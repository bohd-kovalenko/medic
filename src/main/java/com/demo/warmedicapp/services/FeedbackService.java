package com.demo.warmedicapp.services;

import com.demo.warmedicapp.entities.Feedback;
import com.demo.warmedicapp.entities.Note;
import com.demo.warmedicapp.payload.responses.FeedbackResponse;

import java.util.List;

public interface FeedbackService {
    List<FeedbackResponse> getAllFeedbacks();

    List<FeedbackResponse> getAllFeedbacksBySoldierId(Integer id);

    void addFeedback(Feedback feedback);

    void updateFeedback(Integer id, Feedback feedback);
}
