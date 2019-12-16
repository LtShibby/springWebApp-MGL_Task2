package com.MGL_Task2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GAME")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id", nullable = false)
    private Long game_id;

    @Column(name = "game_name", nullable = false)
    private String game_name;

    @Column(name = "game_genre")
    private String game_genre;

    public Long getGame_id() {
	return game_id;
    }

    public void setGame_id(Long game_id) {
	this.game_id = game_id;
    }

    public String getGame_name() {
	return game_name;
    }

    public void setGame_name(String game_name) {
	this.game_name = game_name;
    }

    public String getGame_genre() {
	return game_genre;
    }

    public void setGame_genre(String game_genre) {
	this.game_genre = game_genre;
    }

}
