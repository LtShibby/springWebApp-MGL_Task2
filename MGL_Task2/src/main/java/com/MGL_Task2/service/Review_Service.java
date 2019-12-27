package com.MGL_Task2.service;

import java.util.List;

import com.MGL_Task2.model.Review;

public interface Review_Service {

    void saveReview(Review review);

    void updateReview(Review review);

    Review getReview(Long id);

    void deleteReview(Long id);

    List<Review> listReviews();

}
