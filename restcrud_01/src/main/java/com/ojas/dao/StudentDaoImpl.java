package com.ojas.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ojas.pojo.Student;

public class StudentDaoImpl implements StudentDao {
	String msg = null;

	public String CreateStudent(int studentId, String studentName, String mail) {

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		Student obj = new Student();
		obj.setStudentId(studentId);
		obj.setStudentName(studentName);
		obj.setMail(mail);

		int i = (Integer) s.save(obj);
		if (i > 0) {
			msg = "Values inserted";
		} else {
			msg = "Values are not inserted";
		}

		tx.commit();

		s.close();
		sf.close();
		return msg;
	}

	public List<Student> gellAllstudents() {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		Query query = s.createQuery("from Student");
		java.util.List list = query.list();

		tx.commit();
		s.close();
		sf.close();
		return list;
	}

	public Student getById(int StudentId) {
		Student stu = null;
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		//
		stu = s.get(Student.class, StudentId);
		if (stu != null) {
			msg = "record fetched ";
			return stu;
		} else {
			msg = "record not fetched";
		}
		tx.commit();
		s.close();
		sf.close();
		return stu;
	}

	public String deleteById(int StudentId) {
		// public String deleteById(int StudentId) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		// Student std=s.load(arg0, arg1)
		Query query = s.createQuery("DELETE FROM Student WHERE StudentId=:id");
		query.setParameter("id", StudentId);
		int i = query.executeUpdate();
		if (i != 0) {
			msg = "deleted successfully";
		} else {
			msg = "try again";
		}
		tx.commit();
		s.close();
		sf.close();
		return msg;
	}

	public String updateStudent(int studentId, String studentName, String mail) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		Query query = s.createQuery("update Student set studentName=:Name,mail=:mail where StudentId=:id ");
		query.setParameter("id", studentId);
		query.setParameter("Name", studentName);
		query.setParameter("mail", mail);
		int i = query.executeUpdate();
		if (i != 0) {
			msg = "updated successfully";
		} else {
			msg = "try again";
		}

		tx.commit();
		s.close();
		sf.close();
		return msg;
	}

}
