package com.shop.exception;

public class CartException  extends RuntimeException {

	
	
	public CartException()
	{
		
	}
	
	public CartException(String mess)
	{
		super(mess);
	}
}
