package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.ProductEntity;
import com.example.demo.model.ProductModel;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductImpl implements ProductInter {

	@Autowired
	public ProductRepo productrepo;

	public boolean saveProduct(ProductModel product) {
		// TODO Auto-generated method stub

		ProductEntity pentity = new ProductEntity();
//		pentity.setProductName(product.getProductName());
//		pentity.setProductPrice(product.getProductPrice());
//		pentity.setProductQty(product.getProductQty());

		// setters and getters and beanutils are working same functionality........

		BeanUtils.copyProperties(product, pentity);

		ProductEntity productEntity = productrepo.save(pentity);

		boolean flag = false;

		if (productEntity != null) {
			flag = true;
		}

		return flag;
	}

	@Override
	public List<ProductModel> getAllProducts() {
		// TODO Auto-generated method stub
		
		List<ProductEntity> productlist = productrepo.findAll();
		
		
		List<ProductModel> addProducts = new ArrayList<ProductModel>();
		
		for(ProductEntity p:productlist) {
			ProductModel pmodel = new ProductModel();
			BeanUtils.copyProperties(p, pmodel);
			addProducts.add(pmodel);
		}
		
		return addProducts;
	}

	@Override
	public ProductModel getByIdProduct(int productId) {
		// TODO Auto-generated method stub

		Optional<ProductEntity> findbyid = productrepo.findById(productId);
		ProductEntity productEntity = findbyid.get();

		ProductEntity product = new ProductEntity();

		BeanUtils.copyProperties(productEntity, product);

		return null;
	}

	@Override
	public boolean deleteProduct(int productId) {

		// to get the particular ID..
		Optional<ProductEntity> findById = productrepo.findById(productId);
		ProductEntity productEntity = findById.get();
		System.out.println("id is:" + productEntity);

		boolean flag = false;

		if (productEntity != null) {
			productrepo.deleteById(productId);
			flag = true;
		}

		return flag;
	}

}
