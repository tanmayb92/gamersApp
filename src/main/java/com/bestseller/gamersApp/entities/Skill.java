package com.bestseller.gamersApp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table
public class Skill {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String level;
	
	@JsonIgnore
	@OneToMany(mappedBy = "skill")
	private List<GamersGame> gamersGame;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<GamersGame> getGamersGame() {
		return gamersGame;
	}

	public void setGamersGame(List<GamersGame> gamersGame) {
		this.gamersGame = gamersGame;
	}
	
	

}
