package com.ojas.dao;

import java.util.List;

import com.ojas.pojo.Student;

public interface StudentDao {
	public String CreateStudent(int studentId, String studentName, String mail);

	public List<Student> gellAllstudents();

	public Student getById(int StudentId);

	public String deleteById(int StudentId);

	public String updateStudent(int studentId, String studentName, String mail);
}
