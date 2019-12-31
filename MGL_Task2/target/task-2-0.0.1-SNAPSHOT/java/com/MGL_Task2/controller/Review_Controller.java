package com.MGL_Task2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.MGL_Task2.manager.ReviewManager;
import com.MGL_Task2.model.Review;

@Controller
@RequestMapping("/review")
public class Review_Controller {

    @Autowired
    private ReviewManager reviewManager;

    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showFormForAdd(Model model) {
	Review review = new Review();
	model.addAttribute("review", review);
	return "review-form";
    }

    @RequestMapping(value = "/saveReview", method = RequestMethod.POST)
    public ModelAndView saveReview(@RequestParam(value = "review_game_id") String review_game_id,
	    @ModelAttribute("review") Review review) {
	System.out.println("review_game_id for new review: " + review_game_id);
	if (review.getReview_author().equals("")) {
	    review.setReview_author("anonymous");
	}
	review.setReview_game_id(Integer.valueOf(review_game_id));
	System.out.println("review: " + review.toString());
	reviewManager.saveReview(review);
	return new ModelAndView("result", "submittedReview", review);
    }

    @RequestMapping(value = "/updateForm", method = RequestMethod.GET)
    public ModelAndView updateForm(@RequestParam("review_id") String review_id) {
	ModelAndView updateReviewModelAndView = new ModelAndView("review-update-form");
	Review currentReview = reviewManager.getReview(Long.valueOf(review_id));
	updateReviewModelAndView.addObject("currentReview", currentReview);
	return updateReviewModelAndView;
    }

    @RequestMapping(value = "/deleteReview", method = RequestMethod.GET)
    public String deleteReview(@RequestParam("review_id") long review_id) {
	Review reviewToDelete = reviewManager.getReview(Long.valueOf(review_id));
	reviewManager.deleteReview(review_id);
	return "redirect:/review?review_game_id=" + reviewToDelete.getReview_game_id();
    }

    @RequestMapping(value = "/updateReview", method = RequestMethod.POST)
    public String updateReview(@ModelAttribute("review") Review updatedReview) {
	reviewManager.updateReview(updatedReview);
	return "redirect:/review?review_game_id=" + updatedReview.getReview_id();
    }

}
