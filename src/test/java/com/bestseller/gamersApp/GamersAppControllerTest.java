package com.bestseller.gamersApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.bestseller.gamersApp.controller.AppController;
import com.bestseller.gamersApp.entities.Game;
import com.bestseller.gamersApp.entities.Gamer;
import com.bestseller.gamersApp.entities.Skill;
import com.bestseller.gamersApp.service.GameDaoService;
import com.bestseller.gamersApp.service.GamerDaoService;
import com.bestseller.gamersApp.service.SkillDaoService;
import com.bestseller.gamersApp.util.LinkGamer;
import com.bestseller.gamersApp.util.ValidationUtil;


@ExtendWith(MockitoExtension.class)
public class GamersAppControllerTest {
	
	@Mock
	private GamerDaoService gamerDao;
	
	@Mock
	private GameDaoService gameDao;
	
	@Mock
	private SkillDaoService skillDao;
	

    @InjectMocks
    private AppController controller;
    
    
    @Mock
	private ValidationUtil validationUtil;
    
    @Test
    public void testMatchMaking() {
    	Gamer gamer = new Gamer();
    	gamer.setId(10L);
    	gamer.setName("Logan");
    	Mockito.when(gamerDao.findMatchMaking(1L,1L,1L)).thenReturn(Arrays.asList(gamer));
    	
    	List<Gamer> gamers = controller.getPlayersForMatchmaking(1L,1L,1L);
    	assertEquals(gamers.get(0).getName(), "Logan");
    }
    
    @Test
    public void testgetGamerBySkillForGames() {
    	
    	Game game = new Game();
    	game.setGameGenre("sports");
    	game.setGameName("fifa");
    	Mockito.when(gameDao.getGamerBySkillForGames(1L)).thenReturn(Arrays.asList(game));
    	Mockito.when(skillDao.findById(1L)).thenReturn(Optional.of(new Skill()));
    	
    	
    	List<Game> gamers = controller.getGamerBySkillForGames(1L);
    	assertEquals(gamers.get(0).getGameName(), "fifa");
    }

    
}
