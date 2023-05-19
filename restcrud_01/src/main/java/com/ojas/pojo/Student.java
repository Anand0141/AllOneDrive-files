package com.ojas.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	public int StudentId;
	
	public String StudentName;
	
	public String mail;
   
	public Student(){
		
	}
	public Student(int studentId, String studentName, String mail) {
		
		StudentId = studentId;
		StudentName = studentName;
		this.mail = mail;
	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

//	@Override
//	public String toString() {
//		return "Student [StudentId=" + StudentId + ", StudentName=" + StudentName + ", mail=" + mail + "]";
//	}
	
	

}
