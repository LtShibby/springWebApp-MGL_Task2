package com.MGL_Task2.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MGL_Task2.manager.ReviewManager;
import com.MGL_Task2.model.Game;
import com.MGL_Task2.model.Review;

@Repository
public class GameDaoImpl implements GameDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ReviewManager reviewManager;

    private Session getCurrentSession() {
	return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveGame(Game game) {
	getCurrentSession().save(game);
    }

    @Override
    public void updateGame(Game game) {

	CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
	CriteriaUpdate<Game> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Game.class);
	Root<Game> rootGame = criteriaUpdate.from(Game.class);
	criteriaUpdate.set("game_name", game.getGame_name());
	criteriaUpdate.set("game_genre", game.getGame_genre());
	criteriaUpdate.set("game_releaseDate", new LocalDate(game.getGame_releaseDate()));
	criteriaUpdate.where(criteriaBuilder.equal(rootGame.get("game_id"), game.getGame_id()));

	getCurrentSession().createQuery(criteriaUpdate).executeUpdate();
    }

    @Override
    public Game getGame(Long long1) {
	Game game = getCurrentSession().get(Game.class, long1);
	return game;
    }

    @Override
    public void deleteGame(Long game_id) {

	Game game = getGame(game_id);

	List<Review> reviewsForGame = reviewManager.getReviews(game_id);

	if (reviewsForGame.size() > 0) {
	    reviewManager.deleteReviews(game_id);
	}

	if (game != null) {
	    Query hqlQuery = getCurrentSession().createQuery("delete Game where game_id = :game_id");
	    hqlQuery.setParameter("game_id", game_id);
	    hqlQuery.executeUpdate();
	}
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Game> listGames() {
	return getCurrentSession().createQuery("from Game").list();
    }
}
