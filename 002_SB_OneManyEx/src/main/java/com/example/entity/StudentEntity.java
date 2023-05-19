package com.example.entity;

import javax.persistence.Column;
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
@Table(name = "STUDENT")
public class StudentEntity {
	@GenericGenerator(name = "myGenerator",strategy = "increment")
	@GeneratedValue(strategy = GenerationType.AUTO,generator ="myGenerator")
	
	@Id
	@Column(name = "SNO")
private int sno;
	@Column(name = "SNAME")
private String sname;
	@Column(name = "SADD")
private String sadd;

}
