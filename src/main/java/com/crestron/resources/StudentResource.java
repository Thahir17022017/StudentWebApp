package com.crestron.resources;

import java.sql.SQLException;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.crestron.dao.StudentDAO;
import com.crestron.dto.StudentDTO;
import com.crestron.pojos.Student;

@Path("students")
public class StudentResource {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(StudentResource.class.getName());
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student addStudent(Student student) throws SQLException {
		
		save(student);
		return student;
	}
	
	private void save(Student student)
	{
		StudentDTO st = new StudentDTO();
		st.setFirstName(student.getFirstName());
		st.setMiddleName(student.getMiddleName());
		st.setLastName(student.getLastName());
		st.setGender(student.getGender());
		st.setMark1(student.getMark1());
		st.setMark2(student.getMark2());
		st.setMark3(student.getMark3());
		StudentDAO stDAO = new StudentDAO();
		stDAO.save(st);
		 
	}
}
