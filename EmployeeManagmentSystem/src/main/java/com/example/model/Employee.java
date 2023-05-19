package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private int empId;

	private String empFirstName;

	private String empLastName;

	private String designation;

	private String bloodGroup;

	private double salary;

	private String address;

	private long mobile;

}
