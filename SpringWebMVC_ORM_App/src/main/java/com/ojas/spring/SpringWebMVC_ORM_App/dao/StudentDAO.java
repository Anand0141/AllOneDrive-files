package com.ojas.spring.SpringWebMVC_ORM_App.dao;

import java.util.List;

import com.ojas.spring.SpringWebMVC_ORM_App.model.Student;
/**
 * 
 * @author Chandra
 * This is Student Data Accessing Objection
 *
 */
public interface StudentDAO {
	
	public int createStudent(Student student);
	public List<Student> viewAllStudents();
	public void deleteStudent(int studentId);
	public Student editStudent(int studentId);
	public void updateStudent(Student student);

}
