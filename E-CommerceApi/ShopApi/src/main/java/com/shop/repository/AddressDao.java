package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shop.exception.AddressException;
import com.shop.model.Address;



public interface AddressDao  extends JpaRepository<Address, Integer> {

	
	@Query("from Address where state = ?1")
	public Address viewAllAddress(String id) throws AddressException;
	
}
