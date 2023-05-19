package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {
	
	@GenericGenerator(name = "myGenerator",strategy = "increment")
	
@GeneratedValue(generator = "myGenerator" ,strategy = GenerationType.AUTO)	
	@Id
	@Column(name = "ENO")
private int eno;
	@Column(name = "ENAME")

private String ename;
	@Column(name = "SAL")

private String sal;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "e_dno",referencedColumnName = "dno" )
	private DeptEntity dept;

}
