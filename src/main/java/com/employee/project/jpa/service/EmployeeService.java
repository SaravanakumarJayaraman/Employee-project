package com.employee.project.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.project.jpa.entity.Employee;

@Service
public interface EmployeeService {

	List<Employee> fetchAllEmployees();

	Employee saveEmployee(Employee emp);

	Employee updateEmployee(long userId, String firstName) throws Exception;

	void deleteEmployee(long userId);

}
