package com.MGL_Task2.manager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MGL_Task2.model.Review;
import com.MGL_Task2.service.Review_Service;

@Service
@Transactional
public class ReviewManagerImpl implements ReviewManager {

    @Autowired
    private Review_Service reviewService;

    @Override
    public void saveReview(Review review) {
	reviewService.saveReview(review);
    }

    @Override
    public void updateReview(Review review) {
	reviewService.updateReview(review);
    }

    @Override
    public Review getReview(Long id) {
	return reviewService.getReview(id);
    }

    @Override
    public void deleteReview(Long id) {
	reviewService.deleteReview(id);
    }

    @Override
    public List<Review> listReviews() {
	return reviewService.listReviews();
    }

}