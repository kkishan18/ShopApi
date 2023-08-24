package com.shop.service;

import java.time.LocalDate;


import java.util.List;

import com.shop.exception.AddressException;
import com.shop.exception.CartException;
import com.shop.exception.LoginException;
import com.shop.exception.OrderExcetion;
import com.shop.model.Orders;
public interface OrderService {
	
	
	
	public  Orders addOrder(Orders order,String key) throws LoginException, CartException, OrderExcetion;
	
	public  Orders updateCustomer(Orders order,String key) throws LoginException, CartException, OrderExcetion;
	
	public  Orders removeOrder(Integer id,String key) throws LoginException, CartException, OrderExcetion;

	public  Orders viewOrder(Integer id) throws CartException, OrderExcetion;
	
	public List<Orders> viewallOrderByDate(LocalDate date) throws OrderExcetion;
	
	public List<Orders> orderbylocation(String city) throws OrderExcetion, AddressException;
	
	public List<Orders> viewallbyuserid(String userid) throws OrderExcetion;
}
