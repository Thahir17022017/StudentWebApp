package com.crestron.pojos;

public class Student {

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String middleName;
	private String gender;
	private int age;
	private int mark1;
	private int mark2;
	private int mark3;
	private int total;
	private String status;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastName, String middleName, String gender,int age, int mark1, int mark2, int mark3,
			int total,String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.gender = gender;
		this.age = age;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
		this.total = total;
		this.status = status;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", gender="
				+ gender + ", age=" + age + ", mark1=" + mark1 + ", mark2=" + mark2 + ", mark3=" + mark3 + ", total="
				+ total + ", status=" + status + "]";
	}

	
	

}
