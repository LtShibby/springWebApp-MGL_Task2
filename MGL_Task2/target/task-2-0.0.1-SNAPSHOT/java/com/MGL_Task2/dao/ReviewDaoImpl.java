package com.MGL_Task2.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MGL_Task2.model.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
	return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveReview(Review review) {
	getCurrentSession().save(review);
    }

    @Override
    public void updateReview(Review review) {

	CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
	CriteriaUpdate<Review> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Review.class);
	Root<Review> rootReview = criteriaUpdate.from(Review.class);
	criteriaUpdate.set("review_body", review.getReview_body());
	criteriaUpdate.set("review_author", review.getReview_author());
	criteriaUpdate.set("review_rating", review.getReview_rating());
	criteriaUpdate.set("review_game_id", review.getReview_game_id());
	criteriaUpdate.where(criteriaBuilder.equal(rootReview.get("review_id"), review.getReview_id()));

	getCurrentSession().createQuery(criteriaUpdate).executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Review> getReviews(Long review_game_id) {
	List<Review> reviews = getCurrentSession().createQuery("from Review where review_game_id = " + review_game_id)
		.list();
	return reviews;
    }

    @Override
    public void deleteReview(Long review_id) {

	Review review = getReview(review_id);

	if (review != null) {
	    Query hqlQuery = getCurrentSession().createQuery("delete Review where review_id = :review_id");
	    hqlQuery.setParameter("review_id", review_id);
	    hqlQuery.executeUpdate();
	}
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Review> listReviews(Long review_game_id) {

	List<Review> reviews = getReviews(review_game_id);

	if (reviews != null) {
	    Query hqlQuery = getCurrentSession().createQuery("delete Game where game_id = :game_id");
	    hqlQuery.setParameter("game_id", review_game_id);
	    hqlQuery.executeUpdate();
	}

	return getCurrentSession().createQuery("from Review").list();
    }

    @Override
    public Review getReview(Long review_id) {
	Review review = getCurrentSession().get(Review.class, review_id);
	return review;
    }

    @Override
    public void deleteReviews(Long review_game_id) {
	Query hqlQuery = getCurrentSession().createQuery("delete Review where review_game_id = :review_game_id");
	String review_game_id_string = String.valueOf(review_game_id);
	hqlQuery.setParameter("review_game_id", Integer.valueOf(review_game_id_string));
	hqlQuery.executeUpdate();
    }
}
