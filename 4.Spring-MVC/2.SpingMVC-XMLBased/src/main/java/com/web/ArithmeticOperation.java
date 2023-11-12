package com.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArithmeticOperation {
	
	@ResponseBody
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("a") int a, @RequestParam("b") int b) {
		
		ModelAndView res= new ModelAndView();
		res.setViewName("result");
		res.addObject("result", (a+b));
		return res;
	}
	
	@ResponseBody
	@RequestMapping("/sub")
	public ModelAndView sub(HttpServletRequest request, HttpServletResponse response) { 
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		
		ModelAndView res= new ModelAndView();
		res.setViewName("result");
		res.addObject("result", (a-b));
		return res;
	}

}
