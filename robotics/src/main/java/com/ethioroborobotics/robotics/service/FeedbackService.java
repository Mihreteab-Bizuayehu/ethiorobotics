package com.ethioroborobotics.robotics.service;

import com.ethioroborobotics.robotics.entity.Feedback;
import com.ethioroborobotics.robotics.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public Feedback addFeedback(Feedback feedback){

        return feedbackRepository.save(feedback);
    }

    public List<Feedback> getAllFeedbacks(){
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> getFeedbackById(Integer feedbackId){
        return feedbackRepository.findById(feedbackId);
    }

    public Optional<Feedback> updateFeedback(Integer feedbackId,Feedback feedback){
        return feedbackRepository.findById(feedbackId).map(update->{
            update.setRole(feedback.getRole());
            update.setRating(feedback.getRating());
            update.setFeedbackText(feedback.getFeedbackText());
            update.setClientName(feedback.getClientName());

            return feedbackRepository.save(update);
        });
    }

    public void deleteFeedback(Integer feedbackId){
        feedbackRepository.deleteById(feedbackId);
    }

}
