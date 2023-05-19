package com.ojas.spring.model;

import org.springframework.stereotype.Component;

@Component
public class People {

	private Long id;
	private Integer age;
	private String firstName;
	private String lastName;

	public People() {
	}

	public People(Long id, Integer age, String firstName, String lastName) {
		this.id = id;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	public String toString() {
		return id + "\t" + firstName + "\t" + lastName + "\t" + age;
	}

}
