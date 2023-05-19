package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Employee_Entity;
import com.example.Model.Employee;
import com.example.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/MySqlCrud")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

//	@RequestMapping("/loadform")
//	public String viewPage(Model model) {
//
//		Employee employee = new Employee();
//
//		model.addAttribute("emp", employee);
//
//		return "Employee";
//	}

	@PostMapping("/register")
	public String handlerForm(@RequestBody Employee_Entity employee) {
		 int insert = employeeServiceImpl.insert(employee) ;
		 if(insert!=0) {
			 return "Data Sussessfully inserted";
		 }else {
			 return "Something went wrong!....";			 
		 }

		// interact with service layer
	
	}

	@GetMapping("/viewrecordById/{id}")
	public Optional<Employee_Entity> viewAll(@PathVariable int id) {

		return employeeServiceImpl.getEmployeeById(id);
		// model.addAttribute("viewAllProducts", EmployeeById);
		//return "view";
	}
 
	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id) {
		return employeeServiceImpl.deleteEmployee(id);
		//return "redirect:/viewrecords";

	}

	

	@RequestMapping("/update")
	public int updateProduct(@ModelAttribute("Employee") Employee employee) {
		return employeeServiceImpl.updateEmployee(employee);
		//return "redirect:/viewrecords";

	}
}
