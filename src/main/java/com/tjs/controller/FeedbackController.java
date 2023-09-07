package com.tjs.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tjs.entity.Feedback;
import com.tjs.repository.FeedbackRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackController(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        feedback.setEntryDate(new Date()); // Set the entry date to the current date and time
        return feedbackRepository.save(feedback);
    }
}
