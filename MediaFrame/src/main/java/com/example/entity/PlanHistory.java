package com.example.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLANHISTORY")
public class PlanHistory {

//	@GenericGenerator(name = "myGenerator", strategy = "increment")
//	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "myGenerator")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	@Id
	@Column(name = "PublishedDate")
	private LocalDateTime publishedDate;
	
	@Column(name = "Pid")
	private int pId;

	@Column(name = "Pname")
	private String pName;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "storage")
	private double storage;
	
	@Column(name = "Description")
	private String description;
	

	public PlanHistory() {
		super();
	}

	public PlanHistory(LocalDateTime publishedDate, int pId, String pName, double price, double storage,
			String description) {

		this.publishedDate = publishedDate;
		this.pId = pId;
		this.pName = pName;
		this.price = price;
		this.storage = storage;
		this.description = description;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getStorage() {
		return storage;
	}

	public void setStorage(double storage) {
		this.storage = storage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDateTime publishedDate) {
		this.publishedDate = publishedDate;
	}
}
