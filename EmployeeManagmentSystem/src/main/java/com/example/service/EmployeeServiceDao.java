package com.example.service;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeServiceDao {

	public int insert(Employee employee);
	
	public List<Employee> viewAllEmployee();
	
	public Employee edit(int empId);
}
