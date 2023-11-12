package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArithmeticController {
	
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("a") int a, @RequestParam("b") int b) {
		int c = a + b;
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", c);
		mv.setViewName("result");
		
		return mv;
	}
	
	@RequestMapping("/sub")
	public ModelAndView sub(@RequestParam("a") int a, @RequestParam("b") int b) {
		int c = a - b;
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", c);
		mv.setViewName("result");
		
		return mv;
	}

}
