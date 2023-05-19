package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Employee_Entity;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee_Entity, Integer> {

	
	
}
