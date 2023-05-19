package com.ojas.service;

import java.util.List;

import com.ojas.model.Product;

public interface ProductService {
	
	int addProduct(Product pro);
	
	List<Product>viewProducts();

}
