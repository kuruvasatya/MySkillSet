package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArithmeticController {

	
	@ResponseBody
	@GetMapping("/add")
	public String sum(@RequestParam("a") int a, @RequestParam("b") int b) {
		return a+b + "";
	}
}
