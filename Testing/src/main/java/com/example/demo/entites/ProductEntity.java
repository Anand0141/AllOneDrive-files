package com.example.demo.entites;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Product")
public class ProductEntity {

	@Id
	@GenericGenerator(name = "eshwar", strategy = "increment")
	@GeneratedValue( generator="eshwar" , strategy=GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private String productQty;
	private String productPrice;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductQty() {
		return productQty;
	}
	public void setProductQty(String productQty) {
		this.productQty = productQty;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	
	public ProductEntity(int productId, String productName, String productQty, String productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productQty = productQty;
		this.productPrice = productPrice;
	}
	
	public ProductEntity() {
		
	}
	
	
}
