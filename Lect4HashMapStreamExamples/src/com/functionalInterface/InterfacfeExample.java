package com.functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;

public class InterfacfeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		FunctionalInterfaceExamples obj = new FunctionalInterfaceExamples() {
//
//			@Override
//			public String displayShape() {
//				// TODO Auto-generated method stub
//				return "This is a rectangle";
//			}
//
//
//		};
//
//		
//		System.out.println(obj.displayShape());
		
		
		
		
		//Lmbda expression - anonymous or unnamed method 
		//to reduce the boiler plate code
		//help to make code more readble
		//it doesnot executes on its own
		
		
//		FunctionalInterfaceExamples obj = () -> "this is to display ROSE";
//		System.out.println(obj.displayShape());
		
		FunctionalInterfaceExamples obj = (a,b) -> {
			System.out.println("Length is " + a + "Breadth is " + b);
			
			return (a*b);
			};
		System.out.println(obj.displayShape(5, 6));
		System.out.println(obj.displayShape2());
		
		
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4));
		
		
//		ArrayList<Integer> arr2 = new ArrayList<>();
//		arr.add(null);
		
		System.out.println();
		arr.forEach((n)->System.out.println(n));
		
		
	}



}
