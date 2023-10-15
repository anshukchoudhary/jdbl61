package com.oopsconcept.examples;

import java.util.concurrent.CountDownLatch;

public class FinalKeyWords {
	
	
	
	
	//Final var - we can do it in - in block, construcor, static , while declaring
	//Final fun - can not be overiden
	//Final class - can not be inherited
	
	
	
	
	
	
	
	//Variables
	//Methods
	//Class
	
	public final int count = 90;
	public final int count2;
	
	FinalKeyWords(){
		this.count2 = 80;
	}
	
//	FinalKeyWords(int a,int x ){
//		this.count2 = 80;
//	}

	
//	static {
//		count2 = 801;
//	}
	
	// this block will be loaded once class is initiliazed
//	{
//		this.count2 = 78;
//	}
	
	
	
	
	//for fnial method the main property is it can not be overriden
	public final void test() {
		
	}
	
	//final class
	//it can not be inherited 

	public static void main(String[] args) {
		
		//Final
		
		//this.count2 = 90;
		FinalKeyWords obj = new FinalKeyWords();
		//obj.count2 = 107;
		//since the class was already initilaised that is the reson we will not be able to initialise count
		
		
	

	}

}
