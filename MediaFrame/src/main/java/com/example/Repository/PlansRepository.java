package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.entity.PlansEntity;

@Repository

public interface PlansRepository extends JpaRepository<PlansEntity, Integer>{

}
	