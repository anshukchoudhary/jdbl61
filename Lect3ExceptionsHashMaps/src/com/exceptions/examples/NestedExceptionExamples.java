package com.exceptions.examples;

public class NestedExceptionExamples {

	public static void main(String[] args) {

		try {
			A();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("hi i am MAIN !!!!");
	}

	public static void A() {

		try {
			B();
		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}
	
	}

	

	public static void B() {
		try {
			C();
		} catch (ArithmeticException e) {
			//e.printStackTrace();
			throw e;
		}
		//System.out.println("hi i am B!!!!");
	}

	public static void C() {

		try {
			int a = 1 / 0;
		
		} catch (ArithmeticException e) {
			//e.printStackTrace();
			throw e;
		}
		//System.out.println("hi i am C!!!!");
	}



}


