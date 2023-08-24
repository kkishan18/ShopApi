package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Admin;



public interface AdminDao  extends JpaRepository<Admin, Integer>{
	
	public Admin findByemail(String email);

}