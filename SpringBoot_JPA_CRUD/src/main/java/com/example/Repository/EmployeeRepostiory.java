package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.EmployeeRegistration;

@Repository
public interface EmployeeRepostiory extends JpaRepository<EmployeeRegistration, Integer> {

}
