package com.ojas.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ojas.dao.StudentDao;
import com.ojas.dao.StudentDaoImpl;
import com.ojas.pojo.Student;

@Path("/student")
public class StudentService {
	StudentDao dao = new StudentDaoImpl();

	@POST
	@Path("/create/{studentId}/{studentName}/{mail}")
	public String CreateStudent(@PathParam("studentId") int studentId, @PathParam("studentName") String studentName,
			@PathParam("mail") String mail) {
		return dao.CreateStudent(studentId, studentName, mail);
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> gellAllstudents() {
		return dao.gellAllstudents();
	}

	@GET
	@Path("/getbyId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getById(@PathParam("id") int StudentId) {
		return dao.getById(StudentId);

	}

	@PUT
	@Path("/update/{id}/{Name}/{mail}")
	public String updateStudent(@PathParam("id") int StudentId, @PathParam("Name") String studentName,
			@PathParam("mail") String mail) {
		return dao.updateStudent(StudentId, studentName, mail);
	}

	@DELETE
	@Path("/delete/{id}")
	public String deleteById(@PathParam("id") int StudentId) {
		return dao.deleteById(StudentId);
	}

}
