package com.MGL_Task2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MGL_Task2.dao.GameDao;
import com.MGL_Task2.model.Game;

@Service
public class Game_Service_Impl implements Game_Service {

    @Autowired
    private GameDao gameDao;

    @Override
    @Transactional
    public void saveGame(Game game) {
	gameDao.saveGame(game);
    }

    @Override
    @Transactional
    public void updateGame(Game game) {
	gameDao.updateGame(game);
    }

    @Override
    @Transactional
    public Game getGame(Long id) {
	return gameDao.getGame(id);
    }

    @Override
    @Transactional
    public void deleteGame(Long id) {
	gameDao.deleteGame(id);
    }

    @Override
    @Transactional
    public List<Game> listGames() {
	return gameDao.listGames();
    }

}