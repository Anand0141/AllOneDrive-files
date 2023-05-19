package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String showHome() {
		return "HomePage";
	}

	@GetMapping("/welcome")
	public String showWelcomePage() {
		return "WelcomePage";
	}

	@GetMapping("/admin")
	public String showAdminPage() {
		return "AdminPage";
		    
	}

	@GetMapping("/employee")
	public String showEmployee() {
		return "EmployeePage"; 
	}

	@GetMapping("/student")
	public String showStudent() {
		return "StudentPage";
	}
	
	@GetMapping("/denied")
	public String showDenied() {
		return "DeniedPage";
	}
	
}
