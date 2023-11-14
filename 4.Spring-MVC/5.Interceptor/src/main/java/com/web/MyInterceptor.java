package com.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String method = request.getMethod();
		String uri = request.getRequestURI();
		
		System.out.println("I have got a request for " + uri + " using " + method + " method");
		long startTime = System.currentTimeMillis();
		request.setAttribute("start", startTime);
		
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("request is completed......");
		long start = (Long) request.getAttribute("start");
		long end = System.currentTimeMillis();
		
		System.out.println("it took  " + (end-start) + " ms");
	}

}
