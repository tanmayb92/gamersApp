package com.bestseller.gamersApp.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestseller.gamersApp.entities.Skill;

@Repository 
public interface SkillDaoService extends JpaRepository<Skill, Long> {

}
