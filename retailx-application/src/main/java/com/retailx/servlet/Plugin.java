package com.retailx.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.retailx.service.BaseService;
import org.springframework.context.ApplicationContext;


public interface Plugin {
	public void execute(final HttpServletRequest request, final HttpServletResponse response, final ApplicationContext context, final BaseService service);
}
