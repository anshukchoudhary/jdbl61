package com.examples.streamandmultithreading;

import java.util.Arrays;
import java.util.List;

public class Example {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numberList = Arrays.asList(1, 53, 3, 4, 55, 51, 32, 122);
		
		List<Integer> list2 = numberList.stream().map(x -> {
			System.out.println(x);
			return x;

		}).toList();
		
		
		
		

	}
	
}