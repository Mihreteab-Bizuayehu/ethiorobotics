package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.Feedback;
import com.ethioroborobotics.robotics.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping("/add")
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback){
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackService.addFeedback(feedback));
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks(){
        return ResponseEntity.ok(feedbackService.getAllFeedbacks());
    }

    @GetMapping("/feedback/{id}")
    public ResponseEntity<Optional<Feedback>> getFeedbackById(@PathVariable("id") Integer feedbackId){
        return ResponseEntity.status(HttpStatus.OK).body(feedbackService.getFeedbackById(feedbackId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Feedback>> UpdateFeedback(@PathVariable("id") Integer feedbackId,@RequestBody Feedback feedback){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(feedbackService.updateFeedback(feedbackId,feedback));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable("id") Integer feedbackId){
        feedbackService.deleteFeedback(feedbackId);
        return ResponseEntity.ok("The feedback deleted successfully!");
    }

}
