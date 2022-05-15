package com.bestseller.gamersApp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bestseller.gamersApp.util.LinkGamer;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
class GamersAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void linkGamerToGame() throws Exception {
		LinkGamer lg = new LinkGamer();
		lg.setGameID(1L);
		lg.setGamerID(1L);
		lg.setSkillID(1L);
		lg.setUserName("PeachKai");

		String json = mapper.writeValueAsString(lg);
		mvc.perform(MockMvcRequestBuilders.post("/linkGamerToGame").contentType(MediaType.APPLICATION_JSON)
				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());

	}

}
