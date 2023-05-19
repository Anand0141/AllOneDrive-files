package com.example.model;

public class Product {

	private int pId;
	private String pName;
	private int quantity;
	private double price;
	
	public Product() {
		
	}
	
	public Product(int pId, String pName, int quantity, double price) {
		
		this.pId = pId;
		this.pName = pName;
		this.quantity = quantity;
		this.price = price;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
