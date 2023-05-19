package com.ojas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.entity.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

}
