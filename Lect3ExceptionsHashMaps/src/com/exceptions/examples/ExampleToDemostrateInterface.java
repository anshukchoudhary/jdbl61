package com.exceptions.examples;

public class ExampleToDemostrateInterface implements FirstInterface,SecondInterface{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ExampleToDemostrateInterface obj = new ExampleToDemostrateInterface();
		//obj.getAddress();
		obj.calculate();
		//FirstInterface

	}

//	@Override
//	public void getAddress() {
//		// TODO Auto-generated method stub
//		
//		System.out.println("Inside interface method getAddres");
//		
//	}
	
	
	// we can not have two methods with same name in interface with diffrent return types 
	//can we have two methods we same name and same return type in interface - yes

//	//@Override
//	public void calculate() {
//		// TODO Auto-generated method stub
//		System.out.println("Inside interface method calculate");
//	}
//	
//	
//
//	//@Override
//	public int calculate() {
//		// TODO Auto-generated method stub
//		System.out.println("Inside interface method calculate");
//		return 1;
//	}

}
