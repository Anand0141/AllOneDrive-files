package com.ojas.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.springboot.model.Product;
import com.ojas.springboot.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired(required=true)
	private ProductRepository repo;
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {
		return repo.save(product);
	}
	
	@GetMapping("/all")
	public List<Product> viewAllProducts(){
		return repo.findAll();
	}
	
	@GetMapping("/viwe/{pid}")
	public Optional<Product> viewById(@PathVariable int pid) {
		return repo.findById(pid);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product updateProduct) {
		return repo.saveAndFlush(updateProduct);
	}
	
	@DeleteMapping("/delete/{pid}")
	public void deleteProduct(@PathVariable int pid) {
		repo.deleteById(pid);
	}

}
