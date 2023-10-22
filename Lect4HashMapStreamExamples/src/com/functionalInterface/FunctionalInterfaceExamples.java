package com.functionalInterface;

@FunctionalInterface
public interface FunctionalInterfaceExamples {

	// String displayShape();

	int displayShape(int length, int breadth);
	
	//int calculate();

	default String displayShape2() {

		return "Hi this is displayShape2";

	}

	static String displayShape4() {

		return "Hi this is" + getName();

	}
	
	
	private static String getName() {
		return "Hi Suman";
	}

}

//Any interface with only one abstract method is called FI.
