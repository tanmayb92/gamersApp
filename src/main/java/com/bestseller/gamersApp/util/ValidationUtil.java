package com.bestseller.gamersApp.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bestseller.gamersApp.entities.Country;
import com.bestseller.gamersApp.entities.Game;
import com.bestseller.gamersApp.entities.Gamer;
import com.bestseller.gamersApp.entities.Skill;
import com.bestseller.gamersApp.exceptions.InvalidGameException;
import com.bestseller.gamersApp.exceptions.InvalidGamerException;
import com.bestseller.gamersApp.exceptions.InvalidGeographyException;
import com.bestseller.gamersApp.exceptions.InvalidSkillLevelException;
import com.bestseller.gamersApp.service.CountryDaoService;
import com.bestseller.gamersApp.service.GameDaoService;
import com.bestseller.gamersApp.service.GamerDaoService;
import com.bestseller.gamersApp.service.SkillDaoService;

@Component
public class ValidationUtil {
	
	@Autowired
	private SkillDaoService skillDao;
	
	@Autowired
	private CountryDaoService countryDao;
	
	@Autowired
	private GameDaoService gameDao;
	
	@Autowired
	private GamerDaoService gamerDao;
	
	public Skill validateSkill(Long skillID) {
		Optional<Skill> skill = skillDao.findById(skillID);
		if(skill.isEmpty())
			throw new InvalidSkillLevelException("Invalid Skill level : "+skillID);
		return skill.get();
	}

	
	public Country validateCountry(Long geoID) {
		Optional<Country> country = countryDao.findById(geoID);
		if(country.isEmpty())
			throw new InvalidGeographyException("Invalid Geo : "+geoID);;
		return country.get();
	}
	
	public Game validateGame(Long gameID) {
		Optional<Game> game = gameDao.findById(gameID);
		if(game.isEmpty())
			throw new InvalidGameException("Invalid game entered : "+gameID);
		return game.get();
	}
	
	public Gamer validateGamer(Long gamerID) {
		Optional<Gamer> gamer = gamerDao.findById(gamerID);
		if(gamer.isEmpty())
			throw new InvalidGamerException("Invalid gamer : "+gamerID);
		return gamer.get();
	}
	
}
