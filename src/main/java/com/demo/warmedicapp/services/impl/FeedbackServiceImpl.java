package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.entities.Feedback;
import com.demo.warmedicapp.entities.Note;
import com.demo.warmedicapp.exceptions.UnexistingSoldierException;
import com.demo.warmedicapp.exceptions.ValidationException;
import com.demo.warmedicapp.repositories.FeedbackRepository;
import com.demo.warmedicapp.services.FeedbackService;
import com.demo.warmedicapp.services.SoldierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;

    private final SoldierService soldierService;

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public List<Feedback> getAllFeedbacksBySoldierId(Integer id) {
        List<Feedback> feedbacks;

        try {
            feedbacks = feedbackRepository.findBySoldierId(id);
        } catch (Exception e) {
            throw new UnexistingSoldierException(id);
        }

        return feedbacks;
    }

    public void addFeedback(Feedback feedback) {
        soldierService.getSoldierById(feedback.getSoldierId());

        try {
            feedbackRepository.save(feedback);
        } catch (Exception e) {
            throw new ValidationException();
        }
    }

    @Override
    public void updateFeedback(Integer id, Feedback feedback) {
        try {
            feedback.setId(id);

            feedbackRepository.save(feedback);
        } catch (Exception e) {
            throw new ValidationException();
        }
    }
}
