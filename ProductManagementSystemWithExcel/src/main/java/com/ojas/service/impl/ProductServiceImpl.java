package com.ojas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.entity.ProductEntity;
import com.ojas.model.Product;
import com.ojas.repo.ProductRepo;
import com.ojas.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
@Autowired
private	ProductRepo daoImpl;
	@Override
	public int addProduct(Product pro) {
		// TODO Auto-generated method stub
		int count=0;
		ProductEntity proEn=new ProductEntity();
		BeanUtils.copyProperties(pro, proEn);
		/*
		 * proEn.setPname(pro.getPname()); proEn.setQty(pro.getQty());
		 * proEn.setPrice(pro.getPrice());
		 */
		ProductEntity saveEn = daoImpl.save(proEn);
		if(saveEn!=null)
			count=1;
		
		
		return count;
	}
	@Override
	public List<Product> viewProducts() {
		// TODO Auto-generated method stub
		List<Product>addProducts=new ArrayList<Product>();
		
		List<ProductEntity> ProductRecords = daoImpl.findAll();
		
		for(ProductEntity en : ProductRecords)
		{
			Product pro=new Product();
			BeanUtils.copyProperties(en,pro );
			/*
			 * pro.setId(en.getId()); pro.setPname(en.getPname());
			 * pro.setPrice(en.getPrice()); pro.setQty(en.getQty());
			 */
			addProducts.add(pro);
		}
		
		
		
		
		
		return addProducts;
	}

}
