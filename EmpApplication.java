package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@SpringBootApplication
public class EmpApplication {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EmpApplication.class, args);
	}
	@Bean
	public CommandLineRunner initDb() {
		return (args) -> {
			
			//Log.info("initializing db");
			this.employeeRepository.save(new Employee(null,"Karthika","Mumbai", 20));
			this.employeeRepository.save(new Employee(null,"Rahul","Pune", 38));
			this.employeeRepository.save(new Employee(null,"Mehul","Delhi", 41));
			
			
		};
	}

}
