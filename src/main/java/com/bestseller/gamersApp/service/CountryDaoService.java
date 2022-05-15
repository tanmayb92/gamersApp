package com.bestseller.gamersApp.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestseller.gamersApp.entities.Country;

@Repository
public interface CountryDaoService extends JpaRepository<Country, Long> {

}
