package com.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@ComponentScan(value="com.web")
@EnableWebMvc
public class WebAppContext implements WebMvcConfigurer {

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor())
		.addPathPatterns("/**");
	}
	
}
