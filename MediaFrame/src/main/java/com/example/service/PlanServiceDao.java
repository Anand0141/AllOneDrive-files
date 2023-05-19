package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.PlansEntity;

public interface PlanServiceDao {
	
	public String insert(PlansEntity plan);
	
	public List<PlansEntity> viewAll();
	
	public PlansEntity viewById(int pId);
	
	public PlansEntity update(PlansEntity plan);
	
	public void delete(int pId);
}
