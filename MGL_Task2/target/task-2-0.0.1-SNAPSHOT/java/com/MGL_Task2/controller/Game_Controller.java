package com.MGL_Task2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.MGL_Task2.model.Game;
import com.MGL_Task2.service.Game_Service;

@Controller
@RequestMapping("/game")
public class Game_Controller {

    @Autowired
    private Game_Service gameService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listGames(Model model) {
	List<Game> games = gameService.listGames();
	model.addAttribute("games", games);
	return "list-games";
    }

    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showFormForAdd(Model model) {
	Game game = new Game();
	model.addAttribute("game", game);
	return "game-form";
    }

    @RequestMapping(value = "/saveGame", method = RequestMethod.POST)
    public String saveGame(@ModelAttribute("game") Game game) {
	gameService.saveGame(game);
	return "redirect:/game/list";
    }
//
//    @RequestMapping(value = "/updateForm", method = RequestMethod.GET)
//    public String showFormForUpdate(@RequestParam("game_id") long gameId, Model model) {
//	Game game = gameService.getGame(gameId);
//	model.addAttribute("game", game);
//	return "game-update-form";
//    }

    @RequestMapping(value = "/updateForm", method = RequestMethod.GET)
    public String updateForm(@RequestParam("game_id") long game_id, Model theModel) {
	Game game = gameService.getGame(game_id);
	gameService.updateGame(game);
	theModel.addAttribute("game", game);
	return "game-update-form";
    }

    @RequestMapping(value = "/deleteGame", method = RequestMethod.GET)
    public String deleteGame(@RequestParam("game_id") long game_id) {
	gameService.deleteGame(game_id);
	return "redirect:/game/list";
    }

    @RequestMapping(value = "/updateGame", method = RequestMethod.POST)
    public String updateGame(@ModelAttribute("game") Game updatedGame, Model model) {
	gameService.updateGame(updatedGame);
	model.addAttribute("success", "Game " + updatedGame.getGame_name() + " updated successfully");
	return "redirect:/game/list";
    }

}
