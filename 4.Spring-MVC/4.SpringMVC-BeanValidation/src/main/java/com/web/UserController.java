package com.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class UserController {
		
	@PostMapping("/saveUser")
	public String saveUser(@Valid User user, BindingResult result) {
		
		System.out.println(user);
		if(result.hasErrors()) {
			StringBuilder errorMessage = new StringBuilder("Validation error(s): ");
            result.getFieldErrors().forEach(error -> errorMessage.append(error.getDefaultMessage()).append("; "));
            return result.toString();
		}
		
		return "Validation Successful";
	}
}
