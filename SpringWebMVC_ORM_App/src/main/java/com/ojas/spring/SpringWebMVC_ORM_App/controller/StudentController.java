	 package com.ojas.spring.SpringWebMVC_ORM_App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ojas.spring.SpringWebMVC_ORM_App.model.Student;
import com.ojas.spring.SpringWebMVC_ORM_App.service.StudentService;

/**
 * 
 * @author Chandra This is Student Service
 *
 */
@Controller
public class StudentController {
	@Autowired
	private StudentService service;

	@RequestMapping(value = "/")
	public ModelAndView load(Model model) {
		Student student = new Student();
		List<Student> students = service.viewAllStudents();
		model.addAttribute("students", students);
		model.addAttribute("student", student);

		return new ModelAndView("student");
	}

	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public ModelAndView insertStudent(@ModelAttribute Student student) {
		ModelAndView mv = new ModelAndView();
		int i = service.createStudent(student);
		if (i != 0) {
			mv.addObject("msg", "Student Record Inserted Successfully");
			mv.setViewName("student");
		} else {
			mv.addObject("msg", "Student Record Notable to created");
			mv.setViewName("student");
		}
		return mv;

	}

	@RequestMapping(value = "/list")
	public ModelAndView list(Model model) {
		List<Student> students = service.viewAllStudents();
		model.addAttribute("students", students);
		return new ModelAndView("view");
	}

	@RequestMapping(value = "/delete")
	public String deleteStudent(@RequestParam("id") int studentId) {
		service.deleteStudent(studentId);
		return "redirect:/list";
	}

	@RequestMapping(value = "/edit")
	public String editStudent(@RequestParam("id") int studentId, Model model) {
		Student student = service.editStudent(studentId);
		model.addAttribute("student", student);
		return "update";

	}

	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute Student student) {
		ModelAndView mv = new ModelAndView();
		service.updateStudent(student);
		return "redirect:/list";

	}

}
