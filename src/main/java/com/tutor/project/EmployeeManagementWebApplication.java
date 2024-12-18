package com.tutor.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class EmployeeManagementWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementWebApplication.class, args);
		System.out.println("Server started at port 5000");
	}

}
