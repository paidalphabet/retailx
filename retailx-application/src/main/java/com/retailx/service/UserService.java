package com.retailx.service;

import javax.servlet.http.HttpServletRequest;

import com.retailx.service.BaseService;

public interface UserService extends BaseService {
	
	public static final String USER_ID = "userID";
	public static final String SESSION_ID = "sessionID";

	/**
	 * returns if the user is a validated user or not.
	 * @param loginID user login ID  
	 * @param password password from the field
	 * @return if the user is an authentic user or not.
	 */
	String validateLogin(final String loginID, final String password);

	void createUserSession(final HttpServletRequest request, final String userID);
	
}
