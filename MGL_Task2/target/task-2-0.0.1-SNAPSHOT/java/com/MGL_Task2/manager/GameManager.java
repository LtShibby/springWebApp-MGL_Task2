package com.MGL_Task2.manager;

import java.util.List;

import com.MGL_Task2.model.Game;

public interface GameManager {

    void saveGame(Game game);

    void updateGame(Game game);

    Game getGame(Long id);

    void deleteGame(Long id);

    List<Game> listGames();

}
