package com.learning;

import com.learning.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		UserService service = context.getBean(UserService.class);
		service.getData();
		System.out.println(service.getUserName());
		service.throwException();
	}


	@Override
	public void run(String... args)  {
		System.out.println("Actual Method Execution ..");
	}
}
