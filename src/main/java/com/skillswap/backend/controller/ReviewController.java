package com.skillswap.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillswap.backend.entity.Review;
import com.skillswap.backend.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Save Review
    @PostMapping
    public Review saveReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    // Get All Reviews
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // Get Review By ID
    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    // Get Reviews For A User
    @GetMapping("/user/{revieweeId}")
    public List<Review> getReviewsByUser(@PathVariable Long revieweeId) {
        return reviewService.getReviewsByUser(revieweeId);
    }

    // Delete Review
    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {
        return reviewService.deleteReview(id);
    }
}