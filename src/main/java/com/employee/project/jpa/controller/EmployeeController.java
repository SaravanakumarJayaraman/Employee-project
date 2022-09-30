package com.employee.project.jpa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.project.jpa.entity.Employee;
import com.employee.project.jpa.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/list-all-employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {

		List<Employee> employees = employeeService.fetchAllEmployees();
		if (employees != null && !employees.isEmpty()) {
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/registration")
	public ResponseEntity<Employee> registerEmployee(@RequestBody Employee emp) {
		try {
			Employee employee = employeeService.saveEmployee(emp);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PatchMapping("/update/{id}/{firstName}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long userId,
			@PathVariable("firstName") String firstName) {

		try {
			Employee employee = employeeService.updateEmployee(userId, firstName);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") long userId) {

		try {
			employeeService.deleteEmployee(userId);
			return "User deleted Successfully";
		} catch (Exception e) {
			return "error during user deletion";
		}

	}

}
