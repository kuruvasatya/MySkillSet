package com.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.ApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		// 1. create a spring configuration file
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(ApplicationConfiguration.class);
		
		// 2. create dispatcher servlet object
		DispatcherServlet servlet = new DispatcherServlet(context);
		
		ServletRegistration.Dynamic myServeltRegistry = servletContext.addServlet("myServlet", servlet);
		myServeltRegistry.setLoadOnStartup(1);
		
		//3  add mapping
		myServeltRegistry.addMapping("/");
		
		
	}

}
