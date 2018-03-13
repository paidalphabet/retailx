package com.retailx.framework.session;

import javax.servlet.http.HttpServletRequest;

import com.retailx.service.BaseService;
import com.retailx.entity.UserSession;

public interface UserSessionWrapper{
		
	public UserSession createUserSession(final HttpServletRequest request);
	
	public UserSession fetchUserSession(final String sessionID);
	
	public void setBaseService(final BaseService service);
	
}
