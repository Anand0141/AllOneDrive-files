package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entites.ProductEntity;
import com.example.demo.model.ProductModel;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductImpl;

@Controller

public class TestingController {

	@Autowired
	public ProductRepo productRepo;

	@Autowired
	public ProductImpl productimpl;

	@RequestMapping(value = { "/", "/loadForm" })
	public String loadForm(Model model) {

		ProductModel product = new ProductModel();

		model.addAttribute("eshwar", product);
		
		return "addBook";
	}

	@GetMapping("/test")
	public String test() {
		return "Hi am Eshwar";
	}

	@RequestMapping(value = "/addProducts")
	public String saveProduct(@ModelAttribute("eshwar") ProductModel productModel, Model model) {

		boolean addProducts = productimpl.saveProduct(productModel);
		
		String msg = "";

		if (addProducts) {
			msg = "Product Added SuccessFully";
		} else {
			msg = "Product not Added";
		}
		model.addAttribute("msg", msg);
		
		return "addBook";
	}

	@RequestMapping("/viewProducts")
	public String getAllProducts(Model model) {
		List<ProductModel> pAll = productimpl.getAllProducts();
		System.out.println("ssssssssssss"+pAll);
		model.addAttribute("getProducts", pAll);
		return "viewProducts";
	}

	@GetMapping("/getById/{productId}")
	public Optional<ProductEntity> getProductById(@PathVariable int productId) {
		return productRepo.findById(productId);
	}

	@DeleteMapping("/delete/{productId}")
	public void DeleteProduct(@PathVariable int productId) {
		productRepo.deleteById(productId);
	}

	@PutMapping("/updateProducts")
	public ProductEntity updateProduct(@RequestBody ProductEntity productEntity) {
		return productRepo.saveAndFlush(productEntity);
	}

}
