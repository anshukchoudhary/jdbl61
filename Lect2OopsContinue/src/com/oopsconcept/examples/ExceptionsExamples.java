package com.oopsconcept.examples;

public class ExceptionsExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		int a = 1/0;
		System.out.println(a);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("here at line 1444");
		}
		
		int b = 12;
		
		System.out.println("i am at line 11 " + b);

		
		// 1 try catch block
		// throws keywods
	}

}
