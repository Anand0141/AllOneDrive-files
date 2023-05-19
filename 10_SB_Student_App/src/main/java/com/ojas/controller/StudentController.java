package com.ojas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ojas.model.Student;

@Controller
public class StudentController {

	@RequestMapping("/loadForm")
	public String loadForm(Model model)
	{
		Student stu=new Student();
		model.addAttribute("stu", stu);
		
		return "student.jsp";
	}
	
	@RequestMapping("/register")
	public String handleForm(@ModelAttribute("stu")     Student stu)
	{
		
		return "success.jsp";
	}
	
	
	
	
}
