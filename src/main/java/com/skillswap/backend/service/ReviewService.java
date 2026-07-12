package com.skillswap.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillswap.backend.entity.Review;
import com.skillswap.backend.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Save Review
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    // Get All Reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get Review By ID
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    // Get Reviews For A User
    public List<Review> getReviewsByUser(Long revieweeId) {
        return reviewRepository.findByRevieweeId(revieweeId);
    }

    // Delete Review
    public String deleteReview(Long id) {

        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return "Review Deleted Successfully!";
        }

        return "Review Not Found!";
    }
}
