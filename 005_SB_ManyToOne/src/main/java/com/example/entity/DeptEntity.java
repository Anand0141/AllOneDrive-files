package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DEPT")
public class DeptEntity {
	
	@GenericGenerator(name = "myGenerator",strategy = "increment")
	@GeneratedValue(generator = "myGenerator",strategy = GenerationType.AUTO)
@Id
@Column(name = "DNO")
private int dno;
	@Column(name = "DNAME")
private String dname;
	@Column(name = "LOC")
private String location;
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JoinColumn(name="dno" ,referencedColumnName = "DNO")
//	List<EmployeeEntity> employees;
}
