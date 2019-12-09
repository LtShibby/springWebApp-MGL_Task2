package com.MGL_Task2.service;

import java.util.List;
import com.MGL_Task2.model.Game;

public interface Game_Service {

	List<Game> retrieveAllGames();

	Game saveGame(Game game);

}
