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

import com.MGL_Task2.manager.GameManager;
import com.MGL_Task2.model.Game;
import com.MGL_Task2.model.Review;

@Controller
public class MGL_Task2_Controller {

    @Autowired
    private GameManager gameManager;

    @RequestMapping(value = { "/", "/index", "/home" }, method = RequestMethod.GET)
    public String landing() {
	return "index";
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
    public ModelAndView games() {
	return new ModelAndView("games", "command", new Game());
    }

    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    public ModelAndView reviews() {
	return new ModelAndView("reviews", "command", new Review());
    }

    @RequestMapping(value = "/gameList", method = RequestMethod.GET)
    public String gameList() {
	return "gameList";
    }

    @RequestMapping(value = "/fetchAllGames", method = RequestMethod.GET)
    public ResponseEntity<List<Game>> fetchAllGames() {
	return new ResponseEntity<>(gameManager.listGames(), HttpStatus.OK);
    }

    @RequestMapping(value = "/createGame", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createGame(@RequestBody Game game) {
	gameManager.saveGame(game);
	return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updateGame", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateGame(@RequestBody Game game) {
	gameManager.updateGame(game);
	return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteGame", method = RequestMethod.PUT)
    public ResponseEntity<Void> deleteGame(@RequestBody String game_id) {
	System.out.println("game_id = " + game_id);
	gameManager.deleteGame((Long.valueOf(game_id)));
	return new ResponseEntity<>(HttpStatus.OK);
    }
}