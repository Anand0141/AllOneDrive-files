package com.example.service;

import java.util.List;

import com.example.model.Product;

public interface ServiceDao {

	public int insert(Product product);
	
	public List<Product> getProductsById();
	
	public void deleteProduct(int pId);
	
	public Product editProduct(int pId);
	
	public int updateProduct(Product product); 
	
}
