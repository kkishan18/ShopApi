package com.shop.exception;

public class OrderExcetion  extends RuntimeException{
	
	public OrderExcetion()
	{
		
	}
	
	public OrderExcetion(String mess)
	{
		super(mess);
	}

}
