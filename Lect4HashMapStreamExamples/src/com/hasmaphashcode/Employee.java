package com.hasmaphashcode;

public class Employee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1 = new Person();
		person1.id = 1;
		person1.address = "Delhi2222";
		person1.age = 21;
		person1.name = "Micky";
		
		
		Person person2 = new Person();
		person2.id = 1;
		person2.address = "Delhi";
		person2.age = 21;
		person2.name = "Sheetal";
		
		
		System.out.println(person1 == person2);
		
		System.out.println(person1.hashCode());
		System.out.println(person2.hashCode());
		
	
		
		System.out.println(" value of equality check --- " + person1.equals(person2));
		
		System.out.println(person1.hashCode());
		System.out.println(person2.hashCode());
		
		
		
		
		
		
//		
//	
//		
////		Person person2 = new Person();
////		person1.address = "Shimla";
////		person1.age = 22;
////		person1.name = "Juli";
//		
//		Person person3 = new Person();
//		person3.id = 1;
//		person3.address = "Delhi";
//		person3.age = 21;
//		person3.name = "Sheetal";
//		
//		
//		//Person person4 = person1;
//		
////		if(person1 == person3) {
////			System.out.println("address same");
////		}else {
////			System.out.println("address not same");
////		}
//		
////		if(person1 == person4) {
////			System.out.println("address same");
////		}else {
////			System.out.println("address not same");
////		}
//		
//		
//
////		if(person1 == person4) {
////			System.out.println("address same");
////		}else {
////			System.out.println("address not same");
////		}
//		
//		Person person4 = person3;
//		System.out.println(" value of equality check" + person1.equals(person4));
//		
//		
//		System.out.println(person1.hashCode());
//		System.out.println(person4.hashCode());
//		
		

	}

}
