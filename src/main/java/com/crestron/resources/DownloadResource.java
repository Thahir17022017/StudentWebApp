package com.crestron.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crestron.dao.StudentDAO;
import com.crestron.dto.StudentDTO;
import com.crestron.pojos.Student;
import com.crestron.pojos.StudentDownload;

@Path("download")
public class DownloadResource {
	
	private static final long serialVersionUID = 1L;

	final static Logger logger = LoggerFactory.getLogger(DownloadResource.class);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public StudentDownload getStudent(@QueryParam("search") String search){
		
		logger.info("Search String : "+search);
		return searchStudent(search);
		
	}
	
	private StudentDownload searchStudent(String search)
	{
		StudentDAO stdDao = new StudentDAO();
		StudentDownload download = new StudentDownload();
		StudentDTO stDto = stdDao.findStudent(search);
		logger.info("Student search is complete");
		if(stDto.getFirstName().equalsIgnoreCase(search) && stDto.getLastName().equalsIgnoreCase(search) &&
				stDto.getMiddleName().equalsIgnoreCase(search))
		{
			download.setName(search);
			download.setStatus("fail");
			logger.info("Failure in finding student");
		}
		else
		{
			download.setName(search);
			download.setStatus("pass");
			Student student = new Student();
			student.setFirstName(stDto.getFirstName());
			student.setMiddleName(stDto.getMiddleName());
			student.setLastName(stDto.getLastName());
			student.setGender(stDto.getGender());
			student.setAge(stDto.getAge());
			student.setMark1(stDto.getMark1());
			student.setMark2(stDto.getMark2());
			student.setMark3(stDto.getMark3());
			student.setTotal(stDto.getTotal());
			download.setStudent(new Student[] {student});
			logger.info("Success in finding student");
			
		}
		
		return download;
		
		
	}

}
