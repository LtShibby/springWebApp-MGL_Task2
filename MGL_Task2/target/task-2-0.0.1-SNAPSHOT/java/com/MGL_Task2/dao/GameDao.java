package com.MGL_Task2.dao;

import java.util.List;

import com.MGL_Task2.model.Game;

public interface GameDao {

    void addGame(Game game);

    void updateGame(Game game);

    Game getGame(Long id);

    void deleteGame(Long id);

    List<Game> listGames();

}