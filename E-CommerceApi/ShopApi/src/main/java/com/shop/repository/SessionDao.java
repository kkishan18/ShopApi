package com.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Session;


public interface SessionDao  extends JpaRepository<Session, Integer>{

	
	public Session findByuuid(String uuid);
	
}
