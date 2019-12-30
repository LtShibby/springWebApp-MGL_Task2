package com.MGL_Task2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.MGL_Task2.manager.ReviewManager;
import com.MGL_Task2.model.Review;

@Controller
@RequestMapping("/review")
public class Review_Controller {

    @Autowired
    private ReviewManager reviewManager;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listReviews(Model model) {
	List<Review> reviews = reviewManager.listReviews();
	model.addAttribute("reviews", reviews);
	return "list-reviews";
    }

    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showFormForAdd(Model model) {
	Review review = new Review();
	model.addAttribute("review", review);
	return "review-form";
    }

    @RequestMapping(value = "/saveReview", method = RequestMethod.POST)
    public String saveReview(@ModelAttribute("review") Review review) {
	reviewManager.saveReview(review);
	return "redirect:/review/list";
    }
//
//    @RequestMapping(value = "/updateForm", method = RequestMethod.GET)
//    public String showFormForUpdate(@RequestParam("review_id") long reviewId, Model model) {
//	Review review = reviewManager.getReview(reviewId);
//	model.addAttribute("review", review);
//	return "review-update-form";
//    }

    @RequestMapping(value = "/updateForm", method = RequestMethod.GET)
    public String updateForm(@RequestParam("review_id") long review_id, Model theModel) {
	Review review = reviewManager.getReview(review_id);
	reviewManager.updateReview(review);
	theModel.addAttribute("review", review);
	return "review-update-form";
    }

    @RequestMapping(value = "/deleteReview", method = RequestMethod.GET)
    public String deleteReview(@RequestParam("review_id") long review_id) {
	reviewManager.deleteReview(review_id);
	return "redirect:/review/list";
    }

    @RequestMapping(value = "/updateReview", method = RequestMethod.POST)
    public String updateReview(@ModelAttribute("review") Review updatedReview, Model model) {
	reviewManager.updateReview(updatedReview);
	model.addAttribute("success", "Review " + updatedReview.getReview_name() + " updated successfully");
	return "redirect:/review/list";
    }

}
