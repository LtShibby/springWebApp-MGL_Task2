package com.MGL_Task2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MGL_Task2.dao.ReviewDao;
import com.MGL_Task2.model.Review;

@Service
@Transactional
public class Review_Service_Impl implements Review_Service {

    @Autowired
    private ReviewDao reviewDao;

    @Override
    public void saveReview(Review review) {
	reviewDao.saveReview(review);
    }

    @Override
    public void updateReview(Review review) {
	reviewDao.updateReview(review);
    }

    @Override
    public Review getReview(Long id) {
	return reviewDao.getReview(id);
    }

    @Override
    public List<Review> getReviews(Long review_game_id) {
	return reviewDao.getReviews(review_game_id);
    }

    @Override
    public void deleteReview(Long id) {
	reviewDao.deleteReview(id);
    }

    @Override
    public List<Review> listReviews(Long game_id) {
	return reviewDao.listReviews(game_id);
    }

}