package com.ojas.model;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public class Student {
	
	public int sid;
	public String firstName;
	public String lastName;
	public String email;
	public double mobile;
	
	public Student(){}

	public Student(int sid, String firstName, String lastName, String email, double mobile) {
		super();
		this.sid = sid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getMobile() {
		return mobile;
	}

	public void setMobile(double mobile) {
		this.mobile = mobile;
	}
	
	

}
