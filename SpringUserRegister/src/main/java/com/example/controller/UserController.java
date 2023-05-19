package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Users;
import com.example.service.IUserServiceImpl;

@Controller
@RequestMapping("/details")
public class UserController {

	@Autowired
	public IUserServiceImpl iUserServiceImpl;

	// Show Registration Page

	@GetMapping("/reg")
	public String showReg() {
		return "UserRegister";
	}

	// Read Form data for Save Operation
	@PostMapping("/insert")
	public String SaveUser(@ModelAttribute Users user, Model model) {
		Integer id = iUserServiceImpl.SaveUser(user);

		String msg = "user " + id + "saved";

		model.addAttribute("message", msg);
		return "UserRegister";

	}

}
