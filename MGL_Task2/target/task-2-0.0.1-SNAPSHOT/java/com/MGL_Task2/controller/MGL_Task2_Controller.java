package com.MGL_Task2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.MGL_Task2.model.Game;
import com.MGL_Task2.model.Review;
import com.MGL_Task2.service.Game_Service;

@Controller
public class MGL_Task2_Controller {

    @Autowired
    private Game_Service javaGameService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landing() {
	return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
	return "index";
    }

    @RequestMapping(value = "/home")
    public ModelAndView home() {
	return new ModelAndView("index");
    }

    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public ModelAndView review() {
	return new ModelAndView("review", "command", new Review());
    }

    @RequestMapping(value = "/addReview", method = RequestMethod.POST)
    public ModelAndView addReview(Review review, ModelMap model) {
	if (review.getAuthor().equals("")) {
	    review.setAuthor("anonymous");
	}
	return new ModelAndView("result", "submittedReview", review);
    }

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public ModelAndView game() {
	return new ModelAndView("games", "command", new Game());
    }

    @RequestMapping(value = "/gameList", method = RequestMethod.GET)
    public String gameList() {
	return "gameList";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Game>> fetchAllGames() {
	return new ResponseEntity<>(javaGameService.listGames(), HttpStatus.OK);
    }

    @RequestMapping(value = "/createGame", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createGame(@RequestBody Game game) {
	javaGameService.addGame(game);
	return new ResponseEntity<>(HttpStatus.CREATED);
    }
}