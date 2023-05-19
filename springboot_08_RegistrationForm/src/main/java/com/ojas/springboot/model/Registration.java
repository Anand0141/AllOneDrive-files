package com.ojas.springboot.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registration {

	@Id
	@GenericGenerator(name = "myGenaretor",strategy = "increment")
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "myGenaretor")
	private int id;
	private String firstName;
	private String secondName;
	private int age;
	private Date dob;
	private String city;
}
