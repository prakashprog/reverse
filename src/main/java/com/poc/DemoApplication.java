package com.poc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	List<Employee> employeeList = new ArrayList<Employee>();

	@PostConstruct
	private void postConstruct() {
		for (int j = 1; j <= 200; j++) {

			employeeList.add(new Employee("emp" + j));

		}
	}

	@GetMapping("/employees/reverse")
	public List<Employee> getReverseEmployees() throws Exception {

		ReverseCoverter rc = new ReverseCoverter(employeeList);
		rc.mask();

		return employeeList;
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() throws Exception {

		return employeeList;
	}

}
