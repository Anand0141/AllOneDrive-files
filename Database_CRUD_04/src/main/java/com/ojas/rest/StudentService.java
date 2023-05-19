package com.ojas.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ojas.dao.StudentDAO;
import com.ojas.dao.StudentDAOImpl;
import com.ojas.model.Student;

@Path("/students")
public class StudentService {

	StudentDAO dao = new StudentDAOImpl();

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents() {
		return dao.getAllStudents();
	}

	@GET
	@Path("/get/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentById(@PathParam("studentId") int studentId) {
		return dao.getStudentById(studentId);
	}

	@POST
	@Path("/create/{sid}/{firstName}/{lastName}/{email}/{mobile}")
	public String createStudent(@PathParam("sid") int sid, @PathParam("firstName") String firstName,
			@PathParam("lastName") String lastName, @PathParam("email") String email,
			@PathParam("mobile") double mobile) {
		return dao.createStudent(sid, firstName, lastName, email, mobile);
	}

	@PUT
	@Path("/update/{sid}/{firstName}/{lastName}/{email}/{mobile}")

	public String updateStudent(@PathParam("sid") int sid, @PathParam("firstName") String firstName,
			@PathParam("lastName") String lastName, @PathParam("email") String email,
			@PathParam("mobile") double mobile) {
		return dao.updateStudent(sid, firstName, lastName, email, mobile);
	}

	@DELETE
	@Path("/delete/{studentId}")
	public String deleteStudent(@PathParam("studentId") int studentId) {
		return dao.deleteStudent(studentId);
	}
}
