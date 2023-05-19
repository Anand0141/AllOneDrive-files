package com.ojas.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.springboot.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
