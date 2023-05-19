package com.ojas.spring.SpringWebMVC_ORM_App.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ojas.spring.SpringWebMVC_ORM_App.model.Student;
@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public int createStudent(Student student) {
		int i = (Integer)ht.save(student);
		return i;
	}

	@Override
	public List<Student> viewAllStudents() {
		// TODO Auto-generated method stub
		return ht.loadAll(Student.class);
	}

	@Override
	public void deleteStudent(int studentId) {
		Student student = ht.get(Student.class, studentId);
		if(student!=null) {
		ht.delete(student);
		}else {
			System.out.println("Notable to deleted");
		}
		
	}

	@Override
	public void updateStudent(Student student) {
		ht.saveOrUpdate(student);
		
	}

	@Override
	public Student editStudent(int studentId) {
		// TODO Auto-generated method stub
		return  ht.get(Student.class, studentId);
	}

}
