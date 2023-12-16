package com.learning.HelloWorld;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
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
		SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.run();
	}

}
