package com.exceptions.examples;

import java.io.FileNotFoundException;

public class CheckException {

	public static void main(String[] args) throws Exception {

		try {
			A();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		// System.out.println("hi i am MAIN !!!!");
	}

	public static void A() {

		try {
			B();
		} catch (ArithmeticException e) {

			System.out.println("hi i am ArithmeticException !!!!");
		} catch (FileNotFoundException e) {
			System.out.println("hi i am FileNotFoundException !!!!");

		} catch (Exception e) {
			System.out.println("hi i am Exception !!!!");

		}

	}

	public static void B() throws FileNotFoundException {
		try {
		int i = 1/0;
		} catch (Exception e) {
			throw e;
		}
			
		
//throw new FileNotFoundException();
		// System.out.println("hi i am B!!!!");
	}

}
