package com.crestron.dto;

public class StudentDTO {
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String middleName;
	private String gender;
	private int mark1;
	private int mark2;
	private int mark3;
	
	
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StudentDTO(String firstName, String lastName, String middleName, String gender, int mark1, int mark2,
			int mark3) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.gender = gender;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getMark1() {
		return mark1;
	}


	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}


	public int getMark2() {
		return mark2;
	}


	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}


	public int getMark3() {
		return mark3;
	}


	public void setMark3(int mark3) {
		this.mark3 = mark3;
	}


	
	
	

	

	
	

}
