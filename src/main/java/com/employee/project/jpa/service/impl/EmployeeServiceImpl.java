package com.employee.project.jpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.project.jpa.entity.Employee;
import com.employee.project.jpa.repository.EmployeeRepository;
import com.employee.project.jpa.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> fetchAllEmployees() {

		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public Employee updateEmployee(long userId, String firstName) throws Exception {
		Optional<Employee> employee = employeeRepository.findById(userId);

		if (employee.isPresent()) {
			Employee updatedEmployee = employee.get();
			updatedEmployee.setFirstName(firstName);
			return employeeRepository.save(updatedEmployee);
		} else {
			throw new Exception("No employee found for the ID");
		}

	}

	@Override
	public void deleteEmployee(long userId) {
		employeeRepository.deleteById(userId);
		
	}
}
