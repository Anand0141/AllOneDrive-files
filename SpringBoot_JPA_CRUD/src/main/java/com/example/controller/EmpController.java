package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Repository.EmployeeRepostiory;
import com.example.model.EmployeeRegistration;

@CrossOrigin
@RestController
//@RequestMapping("/employee")
public class EmpController {
	
	@Autowired
	private EmployeeRepostiory emp;

	@PostMapping("/register")
	public EmployeeRegistration RegistetUser(@RequestBody EmployeeRegistration employee){
		return emp.save(employee);
	}
	
	@GetMapping("/login")
	public List<EmployeeRegistration> getEmployees(){
		return emp.findAll();
	}
}
