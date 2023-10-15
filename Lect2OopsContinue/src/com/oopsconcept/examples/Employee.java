package com.oopsconcept.examples;

public class Employee extends Person {

	
	//method overriding
	//is-a and has-a 
	//employee  is a person
	//father  is a  person
	//Person has an address
	//House has a room or kitchen
	//Car has a engine
	
//	@Override
//	public int getAge() {
//		return 30;
//	}
//	
	@Override
	public String getName() {
		return "My name is xyz1";
	}
	
	public static void main(String[] args) {
		
		Employee emp = new Employee();// 1st way 
		//you want load the methods from only employee class
		System.out.println("Emp age" + emp.getAge());
		
		
		Person person = new Person();//2nd way 
		//you want load the methods from only person class
		System.out.println("Person age " + person.getAge());
		
		//Employee emp2 =  new Person();// 3rd way wrong
		
		Person person2 = new Employee();// you want to load only those which are present in parent class and over ride in child class
		
		System.out.println("Person2 age " +person2.getAge());
		
		System.out.println("Person2 weigth " +person2.getWeight());
		
		System.out.println("Person2 getName " +person2.getName());
		
		
		//int a = 1/0;
		
		int arr[] = {1,23,3};
		System.out.println(" Hashcode ---  " + arr[50]);
		
		SingletonClassExamples obj = SingletonClassExamples.getInstance();
		SingletonClassExamples obj2 = SingletonClassExamples.getInstance();
		
		System.out.println(" Hashcode ---  " + obj);
		System.out.println(" Hashcode ---  " + obj2);
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
