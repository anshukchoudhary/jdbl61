package com.oops.examples;

public class PersonOperation extends Person{
	
	
	public PersonOperation() {
		super();
	}

	public static void main(String[] args) {
		Person obj = new Person();// this how we create a new object.
		obj.address = "Delhi";// can be accesed in same package 
		obj.age = 20;//public
		obj.contact = 92371823;//No modifiers
		//obj.name = "Kiara";//name is private 
		
		obj.setSalary(50000);
		System.out.println( "Salary of person  " + obj.getSalary());
		
		
		System.out.println(obj.toString());
		
		System.out.println(obj.address);
		System.out.println(obj.age);
		//	public Person(int age, String name, String address, String dob, int contact) {
		Person obj2 = new Person(12,"Rahul","Lucknow","25-Dec-1995",939293392);
		System.out.println(obj2.toString());
		
		
		PersonOperation obj4 = new PersonOperation();
		
		
		//Encapsultion - it 
		//Data hiding - using private keyword
		//Data binding - 
		
	}

}
