package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Product")

public class ProductEntity {
	
	@GenericGenerator(name = "myGenerator", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "myGenerator")
	@Id
	private int pId;
	private String pName;
	private int quantity;
	private double price;
	

}
