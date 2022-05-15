package com.bestseller.gamersApp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class GamersGame {

	@Id
	@GeneratedValue
	private Long id;
	
	private String userName;
	
	@ManyToOne
	@JoinColumn(name="game_id")
	private Game game;
	
	
	@ManyToOne
	@JoinColumn(name="skill_id")
	private Skill skill;
	
	@ManyToOne
	@JoinColumn(name="gamer_id")
	private Gamer gamer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Gamer getGamer() {
		return gamer;
	}

	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}
	
}