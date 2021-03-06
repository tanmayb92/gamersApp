package com.bestseller.gamersApp.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestseller.gamersApp.entities.Gamer;

@Repository
public interface GamerDaoService  extends JpaRepository<Gamer, Long>{

	List<Gamer> findMatchMaking(Long skillID, Long gameID, Long geoID);

}
