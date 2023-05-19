package com.ojas.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController {
	@RequestMapping("/hello")
	public ModelAndView home(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("greet");
		return mv;
	}
	@ResponseBody
	@RequestMapping("/hi")
	public String hello(){
		return "helllllll";
	}
}
