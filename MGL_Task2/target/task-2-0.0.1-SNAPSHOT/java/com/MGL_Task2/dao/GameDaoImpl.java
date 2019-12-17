package com.MGL_Task2.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MGL_Task2.model.Game;

@Repository
public class GameDaoImpl implements GameDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
	return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveGame(Game game) {
	System.out.println(game.toString());
	getCurrentSession().save(game);
    }

    @Override
    public void updateGame(Game game) {
	Game gameToUpdate = getGame(game.getGame_id());
	gameToUpdate.setGame_name(game.getGame_name());
	gameToUpdate.setGame_genre(game.getGame_genre());
	getCurrentSession().update(gameToUpdate);
    }

    @Override
    public Game getGame(Long long1) {
	Game game = getCurrentSession().get(Game.class, long1);
	return game;
    }

    @Override
    public void deleteGame(Long id) {
	Game game = getGame(id);
	if (game != null) {
	    getCurrentSession().delete(game);
	}
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Game> listGames() {
	return getCurrentSession().createQuery("from Game").list();
    }

    @Override
    public Game getGameByName(String game_name) {
	@SuppressWarnings("deprecation")
	Criteria cr = getCurrentSession().createCriteria(Game.class);
	cr.add(Restrictions.ilike("game_name", game_name));

	List<?> result = cr.list();
	return (Game) result.get(0);
    }
}
