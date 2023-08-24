package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.dto.ProductDto;


public interface ProductDtoDao extends JpaRepository<ProductDto, Integer> {

	
	
}
