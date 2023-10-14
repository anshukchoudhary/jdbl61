package com.oops.examples;

public class Person {

	// Access modifers - public , private , protected, No Modifiers

	// public - // we should be able accesss anywhere in entire project
	// private - // we should be able accesss only in same class
	// protected - // in the all the classes of same packge and inherited class
	// No modifiers - visible only on same package

	public int age; // default value is 0
	private String name; // null
	protected String address;
	String dob;
	int contact;
	private double salary;
	
	
	
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", address=" + address + ", dob=" + dob + ", contact="
				+ contact + "]";
	}

	
	//Constructor overloading 
	public Person(int age, String name, String address, String dob, int contact) {
		super();
		this.age = age;
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.contact = contact;
	}
	
	public Person() {
		System.out.println("Hi there!!!!!");
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public int getContact() {
		return contact;
	}


	public void setContact(int contact) {
		this.contact = contact;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary - 50.0;
		calculateTax(salary);
		
		
		
	}
	
	private double calculateTax(double salary) {
		return salary;
		
		//do some tax calculation 
		//15% deduction on total and return
		
	}
	
	
	
	
	
	
	
	//public Person(int age)
	
	

}
