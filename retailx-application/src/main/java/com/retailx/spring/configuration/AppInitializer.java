package com.retailx.spring.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.retailx.servlet.ControllerServlet;

public class AppInitializer {//implements WebApplicationInitializer {
/*
	public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		container.setInitParameter("contextConfigLocation", "/WEB-INF/controller-servlet.xml");
		ctx.register(AppConfig.class);
		ctx.setServletContext(container);
		ctx.setConfigLocation("classpath:controller-servlet.xml");

		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new ControllerServlet(ctx));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
*/
}
