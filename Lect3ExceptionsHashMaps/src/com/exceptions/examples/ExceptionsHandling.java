package com.exceptions.examples;

public class ExceptionsHandling {

	public static void main(String[] args) {
		try {
			System.out.println("xyz");
			int a = 1 / 0;
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			System.out.println("hi i am finally block!!!!");
		}

		int b = 12;

		System.out.println("i am at line 11 " + b);

	}

}


