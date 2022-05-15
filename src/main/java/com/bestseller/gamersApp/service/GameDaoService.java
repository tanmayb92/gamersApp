package com.bestseller.gamersApp.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestseller.gamersApp.entities.Game;

@Repository
public interface GameDaoService extends JpaRepository<Game, Long> {

}
