package com.bestseller.gamersApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bestseller.gamersApp.entities.Game;
import com.bestseller.gamersApp.entities.Gamer;
import com.bestseller.gamersApp.entities.GamersGame;
import com.bestseller.gamersApp.exceptions.InvalidSkillLevelException;
import com.bestseller.gamersApp.exceptions.NoGamersForMatchMakingException;
import com.bestseller.gamersApp.service.GameDaoService;
import com.bestseller.gamersApp.service.GamerDaoService;
import com.bestseller.gamersApp.service.GamersGameDaoService;
import com.bestseller.gamersApp.service.SkillDaoService;
import com.bestseller.gamersApp.util.LinkGamer;
import com.bestseller.gamersApp.util.ValidationUtil;



@RestController
public class AppController {
	
	@Autowired
	private GameDaoService gameDao;
	
	@Autowired
	private GamerDaoService gamerDao;
	
	@Autowired
	private GamersGameDaoService gamersGameDao;
	
	@Autowired
	private SkillDaoService skillDao;
	
	@Autowired
	private ValidationUtil validationUtil;
	
	
	@GetMapping(path = "/getMatchMaking/{skillID}/{gameID}/{countryID}")
	public List<Gamer> getPlayersForMatchmaking(@PathVariable Long skillID, @PathVariable Long gameID, @PathVariable Long countryID) {
		
		validationUtil.validateSkill(skillID);
		validationUtil.validateGame(gameID);
		validationUtil.validateCountry(countryID);
		
		List<Gamer> gamers = gamerDao.findMatchMaking(skillID,gameID,countryID);
		
		if(gamers != null && !gamers.isEmpty()) {
			return gamers;
		}
		else {
			throw new NoGamersForMatchMakingException("No Gamer for SkillLevel : "+skillID+" Game : "+gameID+ " Country :"+countryID);
		}
	}
	
	@GetMapping(path = "/getGamerBySkill/{skillID}")
	public List<Game> getGamerBySkillForGames(@PathVariable Long skillID) {
		if(skillDao.findById(skillID).isEmpty())
			throw new InvalidSkillLevelException("Invalid SkillLevel entered : "+skillID);
		return	gameDao.getGamerBySkillForGames(skillID);
	}
	
	@PostMapping(path ="/linkGamerToGame")
	public HttpStatus linkGamerToGame(@RequestBody LinkGamer linkGamer) {
		GamersGame gamesGame = new GamersGame();
		gamesGame.setGamer(validationUtil.validateGamer(linkGamer.getGamerID()));
		gamesGame.setGame(validationUtil.validateGame(linkGamer.getGameID()));
		gamesGame.setSkill	(validationUtil.validateSkill(linkGamer.getSkillID()));
		gamesGame.setUserName(linkGamer.getUserName());
		gamersGameDao.save(gamesGame);
		return HttpStatus.CREATED;
	}


}
