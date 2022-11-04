package com.springboot_backend.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot_backend.backend.model.Employee;
import com.springboot_backend.backend.repository.EmployeeRepository;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


	@Autowired
	private EmployeeRepository employeeRepository; 

	@Override
	public void run(String... args) throws Exception {
		
		Employee employee = new Employee();
	}

}
