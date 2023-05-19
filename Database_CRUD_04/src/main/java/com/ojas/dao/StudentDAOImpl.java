package com.ojas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ojas.db.DBUtility;
import com.ojas.model.Student;

public class StudentDAOImpl implements StudentDAO {

	Connection connection = DBUtility.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<Student> students = new ArrayList<Student>();
	int n = 0;
	String msg;

	public String createStudent(int sid, String firstName, String lastName, String email, double mobile) {
		try {
			ps = connection.prepareStatement("INSERT INTO STUDENTS VALUES(?,?,?,?,?)");
			ps.setInt(1, sid);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, email);
			ps.setDouble(5, mobile);
			n = ps.executeUpdate();
			if (n != 0) {
				msg = "Successfully Student Record Created....";
			} else {
				msg = "Please try again....";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	public List<Student> getAllStudents() {
		try {
			ps = connection.prepareStatement("SELECT * FROM STUDENTS");
			rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setSid(rs.getInt(1));
				student.setFirstName(rs.getString(2));
				student.setLastName(rs.getString(3));
				student.setEmail(rs.getString(4));
				student.setMobile(rs.getDouble(5));
				students.add(student);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

	public Student getStudentById(int studentId) {
		Student student = new Student();
		try {
			ps = connection.prepareStatement("SELECT * FROM STUDENTS WHERE SID=?");
			ps.setInt(1, studentId);
			rs = ps.executeQuery();
			if (rs.next()) {

				student.setSid(rs.getInt(1));
				student.setFirstName(rs.getString(2));
				student.setLastName(rs.getString(3));
				student.setEmail(rs.getString(4));
				student.setMobile(rs.getDouble(5));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	public String updateStudent(int sid, String firstName, String lastName, String email, double mobile) {
		try {
			ps = connection.prepareStatement("UPDATE STUDENTS SET firstname=?,lastname=?,email=?,mobile=? WHERE sid=?");
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, email);
			ps.setDouble(4, mobile);
			ps.setInt(5, sid);
			n = ps.executeUpdate();
			if (n != 0) {
				msg = "Student Record Updated Successfully....";
			} else {
				msg = "Notable to updated Record. Please try again....";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return msg;
	}

	public String deleteStudent(int studentId) {
		try {
			ps = connection.prepareStatement("DELETE FROM STUDENTS WHERE sid = ?");
			ps.setInt(1, studentId);
			n = ps.executeUpdate();
			if (n != 0) {
				msg = "Successfully Student Record Deleted...";
			} else {
				msg = "Notable to deleted. Please try again....";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

}
