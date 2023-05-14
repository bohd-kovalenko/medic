package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.entities.Feedback;
import com.demo.warmedicapp.entities.Note;
import com.demo.warmedicapp.entities.Soldier;
import com.demo.warmedicapp.exceptions.UnexistingSoldierException;
import com.demo.warmedicapp.exceptions.ValidationException;
import com.demo.warmedicapp.payload.responses.FeedbackResponse;
import com.demo.warmedicapp.repositories.FeedbackRepository;
import com.demo.warmedicapp.services.FeedbackService;
import com.demo.warmedicapp.services.SoldierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;

    private final SoldierService soldierService;

    public List<FeedbackResponse> getAllFeedbacks() {

        List<Feedback> feedbacks = feedbackRepository.findAll();

        List<FeedbackResponse> feedbackResponses = new ArrayList<>();


        for (int i = 0; i < feedbacks.size(); i++) {
            Soldier soldier = soldierService.getSoldierById(feedbacks.get(i).getSoldierId());

            feedbackResponses.add(new FeedbackResponse(feedbacks.get(i).getSoldierId(),
                    feedbacks.get(i).getText(),
                    soldier.getName(),
                    soldier.getSurname(),
                    soldier.getPatronymic()));
        }

        return feedbackResponses;
    }

    public List<FeedbackResponse> getAllFeedbacksBySoldierId(Integer id) {
        List<Feedback> feedbacks;

        try {
            feedbacks = feedbackRepository.findBySoldierId(id);
        } catch (Exception e) {
            throw new UnexistingSoldierException(id);
        }

        List<FeedbackResponse> feedbackResponses = new ArrayList<>();

        for (int i = 0; i < feedbacks.size(); i++) {
            Soldier soldier = soldierService.getSoldierById(id);

            feedbackResponses.add(new FeedbackResponse(id,
                    feedbacks.get(i).getText(),
                    soldier.getName(),
                    soldier.getSurname(),
                    soldier.getPatronymic()));
        }

        return feedbackResponses;
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
