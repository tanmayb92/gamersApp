package com.bestseller.gamersApp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table
@NamedQueries(value = { @NamedQuery(name = "Game.getGamerBySkillForGames",query = "select g from Game g where exists(select 1 from GamersGame gg where gg.game.id = g.id and gg.skill.id = ?1)")
})
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String gameName;
	
	private String gameGenre;
	
	private String gameType;
	
	private String releaseYear;
	
	@OneToMany(mappedBy = "game",fetch = FetchType.LAZY)
	private List<GamersGame> gamersGame;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameGenre() {
		return gameGenre;
	}

	public void setGameGenre(String gameGenre) {
		this.gameGenre = gameGenre;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public List<GamersGame> getGamersGame() {
		return gamersGame;
	}

	public void setGamersGame(List<GamersGame> gamersGame) {
		this.gamersGame = gamersGame;
	}
	

}
