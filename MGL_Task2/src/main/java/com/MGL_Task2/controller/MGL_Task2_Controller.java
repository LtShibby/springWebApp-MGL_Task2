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
	return new ResponseEntity<>(gameManager.listGames(), HttpStatus.OK);
    }

    @RequestMapping(value = "/createGame", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createGame(@RequestBody Game game) {
	System.out.println("Game being created: " + game.getGame_name());
	System.out.println("Game being created: " + game.getGame_genre());
	System.out.println("Game being created: " + game.getGame_releaseDate());
	System.out.println("Game being created: " + game.getGame_id());
	gameManager.saveGame(game);
	return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updateGame", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateGame(@RequestBody Game game) {
	gameManager.updateGame(game);
	return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteGame", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteGame(@RequestBody Game game) {
	gameManager.deleteGame(game.getGame_id());
	return new ResponseEntity<>(HttpStatus.OK);
    }
}