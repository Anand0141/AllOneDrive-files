package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EMPLOYEEENTITY")
public class EmployeeEntity {

	@GenericGenerator(name = "myGenerator", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "myGenerator")
	@Id
	@Column(name = "empid")
	private int empId;
	
	@Column(name = "FirstName")
	private String empFirstName;
	
	@Column(name = "LastName")
	private String empLastName;
	
	@Column(name = "Designation")
	private String designation;
	
	@Column(name = "BloodGroup")
	private String bloodGroup;
	
	@Column(name = "Salary")
	private double salary;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Mobile")
	private long mobile;

	public EmployeeEntity() {

	}


	public EmployeeEntity(int empId, String empFirstName, String empLastName, String designation, String bloodGroup,
			double salary, String address, long mobile) {
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.designation = designation;
		this.bloodGroup = bloodGroup;
		this.salary = salary;
		this.address = address;
		this.mobile = mobile;
	}



	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
}
