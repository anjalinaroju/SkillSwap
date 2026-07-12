//package com.skillswap.backend.entity;
//
//public class Review {
//
//}

package com.skillswap.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private User reviewer;

    @ManyToOne
    @JoinColumn(name = "reviewee_id")
    private User reviewee;

    private int rating;

    private String comment;

    // Empty Constructor
    public Review() {

    }

    // Parameterized Constructor
    public Review(Long id, User reviewer, User reviewee, int rating, String comment) {
        this.id = id;
        this.reviewer = reviewer;
        this.reviewee = reviewee;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public User getReviewee() {
        return reviewee;
    }

    public void setReviewee(User reviewee) {
        this.reviewee = reviewee;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}