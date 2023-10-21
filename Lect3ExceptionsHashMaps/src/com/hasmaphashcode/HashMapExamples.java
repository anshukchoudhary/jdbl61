package com.hasmaphashcode;

import java.util.HashMap;

public class HashMapExamples {
	
	
	//Stores data in form of key value pairs
	//works on this hashing
	//key ------ value
	//only 1 null key we can have
	// we can have mulitple null values
	//methods are non- synchronization
	//order is not maintained in hashmap -------> 
	//LinkedHashMap - order is maintained
	//Duplicate key is not allowed

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//key --- Integer
		//value - String
		HashMap<Integer,String> map  = new HashMap<>();
		map.put(12, null);
		map.put(13, null);
		map.put(14, "test");
		map.put(14,"Kaira");
	 
		
		System.out.println(map.get(14));
		
		HashMap<Person,Boolean> personMap  = new HashMap<>();
		Person person1 = new Person();
		person1.id = 1;
		person1.address = "Delhi";
		person1.age = 21;
		person1.name = "Micky";
		
		
		Person person2 = new Person();
		person2.id = 1;
		person2.address = "Delhi";
		person2.age = 21;
		person2.name = "Micky";
		
		personMap.put(person2, true);
		personMap.put(person1, false);
		
		
		System.out.println(personMap.toString());
		
		
		
		
	}

}
