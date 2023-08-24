package com.shop.service;

import java.util.List;

import com.shop.exception.AddressException;
import com.shop.exception.LoginException;
import com.shop.model.Address;


public interface AddressService {

	
	
	public Address addAddress(Address add , String key) throws AddressException, LoginException;
	
	public Address updateAddress(Address add, String key) throws AddressException , LoginException;
	
	public String removeAddress(Integer addressId,String key) throws AddressException, LoginException;
	
	public List<Address> viewAlladdress();
	
	public Address viewAddress(Integer id) throws AddressException;
	
}
