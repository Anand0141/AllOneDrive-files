package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.ProductEntity;
import com.example.model.Product;
import com.example.repository.ProductRepository;

@Service
public class ServiceDaoImpl implements ServiceDao {

	@Autowired
	private ProductRepository repo;
	int count = 0;

	public int insert(Product pro) {
		ProductEntity product = new ProductEntity();
		product.setPName(pro.getpName());
		product.setQuantity(pro.getQuantity());
		product.setPrice(pro.getPrice());

		ProductEntity save = repo.save(product);
		if (save != null) {
			count = 1;
		}
		return count;
	}

	public List<Product> getProductsById() {

		List<Product> addProducts = new ArrayList<Product>();

		List<ProductEntity> records = repo.findAll();

		for (ProductEntity record : records) {

			Product product = new Product();
			product.setpId(record.getPId());
			product.setpName(record.getPName());
			product.setPrice(record.getPrice());
			product.setQuantity(record.getQuantity());
			addProducts.add(product);
		}
		return addProducts;
	}

	public void deleteProduct(int pId) {
		repo.deleteById(pId);
	}

	public Product editProduct(int pId) {
		Optional<ProductEntity> findById1 = repo.findById(pId);
		ProductEntity productEntity = findById1.get();
		Product product = new Product();
		BeanUtils.copyProperties(productEntity, product);
		return product;
	}

	public int updateProduct(Product product) {
		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(product, productEntity);
		ProductEntity pro = repo.saveAndFlush(productEntity);
		if (pro != null) {
			count = 1;
		}
		return count;

	}

}
