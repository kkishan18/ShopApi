package com.shop.service;

import com.shop.exception.LoginException;
import com.shop.model.Login;

public interface LoginService {
	
	
	public String logIntoAccount(Login dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;
	

}
