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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="STUDENT_COURSE",joinColumns = 
	{
			@JoinColumn(name="S_NO",referencedColumnName ="SNO" ),
	},inverseJoinColumns = {
			@JoinColumn(name="C_NO",referencedColumnName = "CID")
	}
			
			)
	
	private List<CourseEntity>clist;

}
