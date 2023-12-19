package com.learning.SpringDataJPA;

import com.learning.SpringDataJPA.dao.StudentRepository;
import com.learning.SpringDataJPA.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repo) {
		List<Student> studentList = Arrays.asList(
				new Student("satya","cse"),
				new Student("ganesh","ece"),
				new Student("kuruva", "mca")
		);

		return (args) -> {
			repo.saveAll(studentList);
			System.out.println("Students loaded into table...");
		};
	}
}
