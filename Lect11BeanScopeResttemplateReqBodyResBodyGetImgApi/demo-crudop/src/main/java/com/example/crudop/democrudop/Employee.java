package com.example.crudop.democrudop;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Employee {

	//constraints - i want name, age,gender to be a mandatory field 
	
	
	//@NotNUll, @Min(),@Max(), @Email
	
	//what is jakarta - it is java specification using which we can put constranints on models using annotation
	
	
	//List of validation step wise u can put on any variable
	//UI validation - html - required,  ts - lib or using null check
	//backend - check using jakarta or starter validator 
	//db should have not null constraints 
	
	
	private int id;
	
	@NotNull
	private String name;
	private String designation;
	
	@Min(18)
	@Max(50)
	private int age;
	@NotNull
	private String gender;
	
	@Email
	private String email;

	public Employee() {

	}

	public Employee(int id, String name, String designation, int age, String gender, String email) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
