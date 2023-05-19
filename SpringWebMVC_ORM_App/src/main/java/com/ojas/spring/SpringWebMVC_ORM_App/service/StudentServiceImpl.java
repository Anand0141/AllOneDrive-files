package com.ojas.spring.SpringWebMVC_ORM_App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.spring.SpringWebMVC_ORM_App.dao.StudentDAO;
import com.ojas.spring.SpringWebMVC_ORM_App.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
	private StudentDAO dao;
	
	public int createStudent(Student student) {
		
		return dao.createStudent(student);
	}

	
	public List<Student> viewAllStudents() {
		// TODO Auto-generated method stub
		return dao.viewAllStudents();
	}


	@Override
	public void deleteStudent(int studentId) {
		dao.deleteStudent(studentId);
		
	}


	@Override
	public void updateStudent(Student student) {
		dao.updateStudent(student);
		
	}


	@Override
	public Student editStudent(int studentId) {
		// TODO Auto-generated method stub
		return dao.editStudent(studentId);
	}

}
