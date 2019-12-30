package com.MGL_Task2.manager;

import java.util.List;

import com.MGL_Task2.model.Review;

public interface ReviewManager {

    void saveReview(Review review);

    void updateReview(Review review);

    Review getReview(Long id);

    List<Review> getReviews(Long review_game_id);

    void deleteReview(Long id);

    List<Review> listReviews(Long game_id);

}
