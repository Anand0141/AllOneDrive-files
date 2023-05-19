package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.PlansEntity;
import com.example.service.PlansDaoImpl;

@RestController
@RequestMapping("/api")
public class PlansController {

	@Autowired
	private PlansDaoImpl daoImpl;

	@GetMapping("/")
	public String hello() {
		return "hello Anand";
	}
	

	@PostMapping("/create")
	public String createPlan(@RequestBody PlansEntity Plan) {
		return daoImpl.insert(Plan);
	}

	@GetMapping("/viewall")
	public List<PlansEntity> viewAllPlans() {
		return daoImpl.viewAll();
	}

	@GetMapping("/viewplanbyid/{pId}")
	public PlansEntity viewPlanById(@RequestParam("pId") int pId) {
		return daoImpl.viewById(pId);
	}

	@PutMapping("/update")
	public PlansEntity update(@RequestBody PlansEntity plan) {
		return daoImpl.update(plan);
	}

	@DeleteMapping("/delete/{pId}")
	public void delete(@PathVariable("pId") int pId) {
		daoImpl.delete(pId);
	}

}
