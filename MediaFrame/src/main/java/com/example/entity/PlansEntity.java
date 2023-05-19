package com.example.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "PLANS")
@SQLDelete(sql = "UPDATE plans SET deleted = true WHERE p_id=?")
@Where(clause = "deleted=false")
public class PlansEntity {
	@Id
	@GenericGenerator(name = "myGenerator", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "myGenerator")
	private int pId;
	private String pName;
	private double price;
	private double storage;
	private String description;

	private LocalDateTime publishedDate;
	private boolean deleted = Boolean.FALSE;

	public PlansEntity() {
	}

	public PlansEntity(int pId, String pName, double price, double storage, String description,
			LocalDateTime publishedDate) {

		this.pId = pId;
		this.pName = pName;
		this.price = price;
		this.storage = storage;
		this.description = description;
		this.publishedDate = publishedDate;
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
