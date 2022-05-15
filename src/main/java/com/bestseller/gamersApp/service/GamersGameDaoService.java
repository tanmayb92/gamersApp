package com.bestseller.gamersApp.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestseller.gamersApp.entities.GamersGame;

@Repository
public interface GamersGameDaoService extends JpaRepository<GamersGame, Long> {

}
