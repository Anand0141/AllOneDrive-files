package com.ojas.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.springboot.model.Registration;

public interface RegistrationRepo extends JpaRepository<Registration, Integer> {

}
