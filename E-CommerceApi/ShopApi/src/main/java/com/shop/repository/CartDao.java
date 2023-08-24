package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shop.exception.CustomerException;
import com.shop.model.Cart;
import com.shop.model.Customer;



public interface CartDao  extends JpaRepository<Cart, Integer>{

	
	
	public Cart findByCustomer(Customer customer) throws CustomerException;
	
	
	@Query("select c from Cart c where c.customer.customerId=?1")
	public Cart getCart(Integer custId);
	
	
	
}
