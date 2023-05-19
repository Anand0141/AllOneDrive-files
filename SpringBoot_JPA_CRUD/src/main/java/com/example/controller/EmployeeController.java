package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Repository.EmployeeRepository;
import com.example.model.Employee;

@CrossOrigin
@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repo;
	
	@PostMapping("/create")
	public Employee createProduct(@RequestBody Employee employee) {
		return repo.save(employee);
	}

	@GetMapping("/viewall")
	public List<Employee> viewAllEmployee() {
		return repo.findAll();
	}

	@PostMapping("/update")
	public Employee updateEmployee(@RequestBody Employee updateEmployee) {
		return repo.saveAndFlush(updateEmployee);
	}

	@GetMapping("/getId/{empId}")
	public Optional<Employee> getProductById(@PathVariable int empId) {
		return repo.findById(empId);
	}
	
	@GetMapping("/del/{empId}")
	public void deleteProduct(@PathVariable int empId) {
		repo.deleteById(empId);;	
	}


}
