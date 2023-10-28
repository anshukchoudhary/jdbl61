package com.examples.streamandmultithreading;

import java.util.Optional;

public class NullPointerExceptionExamplesWith {
	private static void printLength(Optional<String> str) {
		//if(str !=null)
		//O
		if(str.isPresent())
		System.out.println("this is from method " + str.get().length());
		else {
			System.out.println("this si from null " + str.get().length());
		}
	}
	
	
	///of - will return u optional contaning value if exist else empty if null
	///it will same like empty object - 
	

	public static void main(String args[]) {
		Optional myString = Optional.ofNullable(null);
		
		//Optional myString = Optional.of(null);
		printLength(myString);
		
		
	}
}