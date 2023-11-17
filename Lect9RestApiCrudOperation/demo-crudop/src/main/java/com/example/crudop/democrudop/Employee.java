package com.example.crudop.democrudop;

public class Employee {

	private int id;
	private String name;
	private String designation;
	private int age;
	private String gender;

	public Employee() {

	}

	public Employee(int id, String name, String designation, int age, String gender) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.age = age;
		this.gender = gender;
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

}
