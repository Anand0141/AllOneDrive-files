package com.ojas.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ojas.springboot.model.Registration;
import com.ojas.springboot.service.RegistrationService;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService service;

	@RequestMapping("/home")
	public ModelAndView registration(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registration.jsp");
		Registration registration = new Registration();
		model.addAttribute("registration", registration);
		return mv;
	}

	@RequestMapping("/data")
	public ModelAndView formSubmit(@ModelAttribute Registration registration) {
		ModelAndView mv = new ModelAndView();
		String msg = service.saveData(registration);
		if (msg != null) {

			mv.addObject("msg", msg);
			mv.setViewName("registration.jsp");
System.out.println(msg);
		}
		return mv;

	}
}
