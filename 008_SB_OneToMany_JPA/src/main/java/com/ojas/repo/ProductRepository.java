package com.ojas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}