package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Entity.Employee_Entity;
import com.example.Model.Employee;

@Service
public interface EmployeeService {

	public int insert(Employee_Entity emp);

	public Optional<Employee_Entity> getEmployeeById(int id);

	public String deleteEmployee(int id);

	public Employee editEmployee(int id);

	public int updateEmployee(Employee emp);

}
