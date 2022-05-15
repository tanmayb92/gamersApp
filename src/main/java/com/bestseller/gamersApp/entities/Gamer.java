package com.bestseller.gamersApp.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@NamedQuery(name = "Gamer.findMatchMaking",query = "select g from Gamer g join fetch g.gamersGame gg where gg.skill.id = ?1 and gg.game.id = ?2 and g.country.id = ?3")
public class Gamer {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@Column(unique=true)
	private String email;
	
	private String gender;
	
	@Past
	private LocalDate dateOfBirth;
	
	private LocalDate creationDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "gamer")
	private List<GamersGame> gamersGame;
	
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public List<GamersGame> getGamersGame() {
		return gamersGame;
	}

	public void setGamersGame(List<GamersGame> gamersGame) {
		this.gamersGame = gamersGame;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	
}
