package com.examples.ploymorphism;

public class Employee {

	private double height;
	private String empName;
	private int age;
	private int empId;
	private double weight;
	
	//Method overloading // way to achieve compile time poly
	//method name can be same
	// but singnature should be diff
	//return type does not matter it can be different
	//Access modifiers does not maater in case of method overloading
	
//	public int getBMI() {
//		return 24;
//	}
	
	public String getBMI() {
		return "xyz";
	}
	
//	public String getBMI() {
//		return "xyz";
//	}
	

	public double getBMI(int weight, int height) {
		return height;
	
	}
	
	public double getBMI(double height, int weight) {
		return height;
	
	}
	
	
}
