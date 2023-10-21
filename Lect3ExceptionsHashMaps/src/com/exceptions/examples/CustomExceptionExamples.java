package com.exceptions.examples;

public class CustomExceptionExamples {

	public static void main(String[] args) throws CustomException {
		try {
			int a = 1 / 0;
			System.out.println(a);
		} catch (ArithmeticException e) {
			
			throw new CustomException("This is exception to identify the arithemetic extption by jdbl61");
		}

	}

}
