package com.retailx.servlet;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.retailx.service.BaseService;
import com.retailx.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class RequestLoggingPlugin implements Plugin {
	
	private static final Logger LOGGER  = Logger.getLogger(UserServiceImpl.class.getName());
	public void execute(final HttpServletRequest request, final HttpServletResponse response, final ApplicationContext context, final BaseService service) {
		LOGGER.info("Logging : httpservletrequest & response");
	}

}
