package com.ojas.spring.SpringWebMVC_ORM_App.service;

import java.util.List;

import com.ojas.spring.SpringWebMVC_ORM_App.model.Student;

public interface StudentService {

	public int createStudent(Student student);
	public List<Student> viewAllStudents();
	public void deleteStudent(int studentId);
	public Student editStudent(int studentId);
	public void updateStudent(Student student);
	
}
