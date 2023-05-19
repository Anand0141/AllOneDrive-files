package com.ojas.dao;

import java.util.List;

import com.ojas.model.Student;

public interface StudentDAO {

	public String createStudent(int sid,String firstName,String lastName,String email,double mobile);

	public List<Student> getAllStudents();

	public Student getStudentById(int studentId);

	public String updateStudent(int sid,String firstName,String lastName,String email,double mobile);

	public String deleteStudent(int studentId);

}
