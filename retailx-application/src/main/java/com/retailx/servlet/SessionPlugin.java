package com.retailx.servlet;

import com.retailx.service.BaseService;
import com.retailx.service.UserService;
import com.retailx.entity.UserSession;
import com.retailx.framework.session.SessionFacadeFactory;
import com.retailx.framework.session.UserSessionHolder;
import com.retailx.framework.session.UserSessionWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SessionPlugin implements Plugin{
	
	public void execute(final HttpServletRequest request, final HttpServletResponse response, final ApplicationContext context, final BaseService service){
		final String sessionID = (String) SessionFacadeFactory.getInstance().getHttpSessionWrapper().getAttribute(request, UserService.SESSION_ID);
		if(StringUtils.isEmpty(sessionID)){
			final UserSession userSession = bootstrapUserSession(request, response, context, service);
			UserSessionHolder.register(userSession);
		}else{
			final UserSessionWrapper userSessionWrapper = SessionFacadeFactory.getInstance().getUserSessionWrapper();
			userSessionWrapper.setBaseService(service);
			final UserSession userSession = userSessionWrapper.fetchUserSession(sessionID);
			UserSessionHolder.register(userSession);
		}
		
	}

	private UserSession bootstrapUserSession(final HttpServletRequest request, final HttpServletResponse response, final ApplicationContext context, final BaseService service){
		final UserSessionWrapper userSessionWrapper = SessionFacadeFactory.getInstance().getUserSessionWrapper();
		userSessionWrapper.setBaseService(service);
		final UserSession userSession = userSessionWrapper.createUserSession(request);
		return userSession;
	}
}
