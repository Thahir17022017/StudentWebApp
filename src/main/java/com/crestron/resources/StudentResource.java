package com.crestron.resources;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.crestron.constants.Constants;
import com.crestron.pojos.Student;
import com.crestron.utils.PropUtils;

@Path("students")
public class StudentResource {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(StudentResource.class.getName());
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student addStudent(Student student) {

		student.setStatus("Student Added");
		logger.info("Abu Property Read:"+PropUtils.readProp("com.crestron.dburl"));
		logger.severe("Student : " + student);
		return student;

	}
}
