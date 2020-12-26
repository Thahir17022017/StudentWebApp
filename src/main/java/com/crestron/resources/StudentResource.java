package com.crestron.resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crestron.dao.StudentDAO;
import com.crestron.dto.StudentDTO;
import com.crestron.pojos.Student;

@Path("students")
public class StudentResource {

	private static final long serialVersionUID = 1L;

	final static Logger logger = LoggerFactory.getLogger(StudentResource.class);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student addStudent(Student student) throws SQLException {
		
		save(student);
		student.setStatus("pass");
		return student;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> readStudents(){
		return getAll();
		
	}
	
	
	private void save(Student student)
	{
		StudentDTO st = new StudentDTO();
		st.setFirstName(student.getFirstName());
		st.setMiddleName(student.getMiddleName());
		st.setLastName(student.getLastName());
		st.setGender(student.getGender());
		st.setAge(student.getAge());
		st.setMark1(student.getMark1());
		st.setMark2(student.getMark2());
		st.setMark3(student.getMark3());
		StudentDAO stDAO = new StudentDAO();
		stDAO.save(st);
		logger.info("Student is saved");
		 
	}
	
	private List<Student> getAll()
	{
		List<Student> allStudents = new ArrayList<>();
		StudentDAO stDAO = new StudentDAO();
		stDAO.getAll().forEach(action->{
			Student student = new Student();
			student.setFirstName(action.getFirstName());
			student.setMiddleName(action.getMiddleName());
			student.setLastName(action.getLastName());
			student.setGender(action.getGender());
			student.setAge(action.getAge());
			student.setMark1(action.getMark1());
			student.setMark2(action.getMark2());
			student.setMark3(action.getMark3());
			student.setTotal(action.getTotal());
			allStudents.add(student);
		});
		return allStudents;
		
	}
}
