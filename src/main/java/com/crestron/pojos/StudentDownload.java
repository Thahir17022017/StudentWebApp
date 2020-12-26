package com.crestron.pojos;

import java.util.Arrays;

public class StudentDownload {
	
	private String name;
	private String status;
	private Student[] student;
	
	public StudentDownload() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public StudentDownload(String name, String status, Student[] student) {
		super();
		this.name = name;
		this.status = status;
		this.student = student;
	}


	@Override
	public String toString() {
		return "StudentDownload [name=" + name + ", status=" + status + ", student=" + Arrays.toString(student) + "]";
	}
	
	
	public String getName() {
		return name;
	}
	


	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Student[] getStudent() {
		return student;
	}
	public void setStudent(Student[] student) {
		this.student = student;
	}
	
	
}
