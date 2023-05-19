package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Employee;
import com.example.service.EmployeeDaoImpl;

@Controller
 @RequestMapping("/api") 
public class EmployeeController {

	@Autowired
	private EmployeeDaoImpl employeeDaoImpl;

	@RequestMapping("/loadform")
	public String welcome(Model model) {

		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee";
	}

	@RequestMapping("/insert")
	public String insert(@ModelAttribute("employee") Employee emp,Model model) {

		String message;
		int insert = employeeDaoImpl.insert(emp);
		if (insert != 0) {
			 message = "Data inserted Successfully";
		} else {
			message="Please try Again...";

		}
		model.addAttribute("msg", message);
		return "employee";
	}
	
	@RequestMapping("/view")
	public String viewAll(Model model){
		
		List<Employee> viewAllEmployee = employeeDaoImpl.viewAllEmployee();
		model.addAttribute("viewAll", viewAllEmployee);
		return "view_details";
	}
	
	@RequestMapping("/edit/{empId}")
	public String edit(@PathVariable("empId") int empId,Model model){
		Employee edit = employeeDaoImpl.edit(empId);
		model.addAttribute("edit", edit);
		return "edit_emp";
		
	}
	
}
