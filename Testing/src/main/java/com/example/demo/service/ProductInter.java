package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ProductModel;

public interface ProductInter {

	public boolean saveProduct(ProductModel product);

	public List<ProductModel> getAllProducts();

	public ProductModel getByIdProduct(int productId);

	public boolean deleteProduct(int productId);
}
