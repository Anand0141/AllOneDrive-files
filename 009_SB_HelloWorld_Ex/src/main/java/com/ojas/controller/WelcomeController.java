package com.ojas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/api")
public class WelcomeController {

	//http://localhost:8081/helloWorld/hello
	@RequestMapping("/hello")
	public String sayHello()
	{
			return "welcome.jsp";
	}
	
	/*
	 * @RequestMapping("/login") public String verifyUser(HttpServletRequest
	 * req,ServletConfig cg) { String uname = req.getParameter("uname"); String
	 * pass=req.getParameter("pass"); String msg;
	 * if(uname.equals("Admin")&&pass.equals("Admin@123")) { msg="Valid User"; }
	 * else { msg="Invalid User"; }
	 * 
	 * //ServletContext ctx=cg.getServletContext(); req.setAttribute("msg",msg); //
	 * ctx.setAttribute("msg",msg); return "view.jsp";
	 * 
	 * }
	 */
	
	
	
	/*
	 * @RequestMapping("/login") public String verifyUser(@RequestParam String
	 * uname,@RequestParam String pass,Model model) {
	 * 
	 * String msg; if(uname.equals("Admin")&&pass.equals("Admin@123")) {
	 * msg="Valid User"; } else { msg="Invalid User"; }
	 * 
	 * model.addAttribute("msg", msg); return "view.jsp";
	 * 
	 * }
	 */	
	
	
	@RequestMapping("/login")
	public String verifyUser(@ModelAttribute   User user,Model model)
	{
		
		String msg;
		if(user.getUname().equals("Admin")&&user.getPass().equals("Admin@123"))
		{
		msg="Valid User";
		}
	else
	{
		msg="Invalid User";
	}
	
	model.addAttribute("msg", msg);
		return "view.jsp";

}

	
	
	
	
	
	
	
	
	
}