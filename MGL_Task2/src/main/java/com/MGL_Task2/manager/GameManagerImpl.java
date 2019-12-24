package com.MGL_Task2.manager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MGL_Task2.model.Game;
import com.MGL_Task2.service.Game_Service;

@Service
@Transactional
public class GameManagerImpl implements GameManager {

    @Autowired
    private Game_Service gameService;

    @Override
    public void saveGame(Game game) {
	gameService.saveGame(game);
    }

    @Override
    public void updateGame(Game game) {
	gameService.updateGame(game);
    }

    @Override
    public Game getGame(Long id) {
	return gameService.getGame(id);
    }

    @Override
    public void deleteGame(Long id) {
	gameService.deleteGame(id);
    }

    @Override
    public List<Game> listGames() {
	return gameService.listGames();
    }

}