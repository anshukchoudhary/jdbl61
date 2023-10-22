package com.hasmaphashcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

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
		
		HashMap<Person,Boolean> personMap  = new HashMap<>();//LinkedHashMap
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
		
		//Collections
		
		
		
		System.out.println(person2.hashCode());
		System.out.println(person1.hashCode());
		
		System.out.println("to get the value " + personMap.get(person2));
		
		System.out.println(personMap.toString());
		
	//B1	//K5,V5 -> K6,V6 -> K7,V7 
	//B2	//K,V -> K2,V2 -> K3,V3 -> 
		//TREEIFY_THRESHOLD = 8;
		//UNTREEIFY_THRESHOLD = 6;
		//SIZE OF HASHMAP - CURRENNT COUNT OF ELEMENT IN HASHMAP
		//CAPACITY - Max holding capacity -
		//initial load factor - .75
		
		
		
		///////////////////////////////////////////////////////////////////////////
		HashSet<Integer> set = new HashSet<>();//Linekd hashset
		
		int arr[] = {12,13,14,14,15,15,16,17};
		for(int i = 0;i<arr.length; i++) {
		set.add(arr[i]);
		}
		
		//System.out.println(set.contains(20));
		//System.out.println(set.contains(19));
		
		
		for(Integer element : set) {
			System.out.print(element + " ");
			
		}
		
		Iterator<Integer> it = set.iterator();
		
//		while(it.hasNext()) {
//			
//			System.out.println(it.next());
//		}
		
		
		
		
		
	}

}
