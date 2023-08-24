package com.shop.service;

import java.util.List;

import com.shop.dto.ProductDto;
import com.shop.exception.CartException;
import com.shop.exception.LoginException;
import com.shop.exception.ProductException;
import com.shop.model.Cart;


public interface CartService {

	
	
	public Cart addProductToCart(Integer productId, Integer quantity, String key) throws CartException,LoginException,ProductException;
	
	
	public List<ProductDto> removeProductfromCart(Integer productId, String key) throws CartException,LoginException,ProductException;
	
	
	public List<ProductDto> updateProductQuantity(Integer productId, Integer quantity, String key)throws CartException,LoginException,ProductException;
	
	
	
	public Cart removeAllproduct(String key) throws CartException,LoginException;
	
	public List<ProductDto> viewAllProducts(String key) throws CartException,LoginException;
	
	
	
}
