package com.learning.HelloWorld;


import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan
public class Application {
	public static void main(String[] args) {
		/**
		 * 1. SpringApplication without any source
		 * error: Application run failed: Sources must not be empty
		 */
//		SpringApplication springApplication = new SpringApplication();
//		springApplication.run();

		/**
		 * 2. SpringApplication with source and without @EnableAutoConfiguration annotation
		 * error: Exception encountered during context initialization - cancelling refresh attempt: org.springframework.context.ApplicationContextException: Unable to start web server
		 */
//		SpringApplication springApplication = new SpringApplication(Application.class);
//		springApplication.run();

		/**
		 * 3. SpringApplication with source and with @EnableAutoConfiguration annotation but no @ComponentScan annotation
		 * error: REST API return 404 not found,
		 */
//		SpringApplication springApplication = new SpringApplication(Application.class);
//		springApplication.run();

		/**
		 * 4. if we want to change the port, we need to pass the run time arguments
		 * --server.port = 9090
		 * to pass this arguments to Spring boot
		 */
//		SpringApplication springApplication =  new SpringApplication(Application.class);
//		springApplication.run(args);

		/**
		 * 5. Instead of creating the object for SpringBootApplication we can rather use the static method
		 */
		SpringApplication.run(Application.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("I am callback method called after context initialization " + Arrays.toString(args));
		};
	}

	@Bean
	ApplicationRunner applicationRunner() {
		return (args) -> {
			System.out.println("I am another callback method called after context initialization " + Arrays.toString(args.getSourceArgs()));
		};
	}

}
