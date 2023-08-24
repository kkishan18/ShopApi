package com.shop.service;

import java.util.List;

import com.shop.exception.CustomerException;
import com.shop.exception.LoginException;
import com.shop.model.Customer;



public interface CustomerService {

	
	
	
	public Customer addCustomer(Customer customer) throws CustomerException;

	public Customer updateCust(Customer customer, String key) throws CustomerException, LoginException;
	
	public Customer removeCustomer(Customer customer,String key) throws CustomerException, LoginException;
	
	public Customer viemCustomer(Integer cusInteger) throws CustomerException;
	
//	public List<Customer> viewAll(String location) throws CustomerException;
	
	
}
