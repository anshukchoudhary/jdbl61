package com.examples.streamandmultithreading;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FactorialExamples {

	// 5 = 5 * 4 * 3* 2 * 1
	// 6 = 6* 5* 4*____ till 1
	// 50 = 50 * 49 * 48 * ____ till 1

	// What is identity of any operator
	// + identity = 0;
	// * identity = 1;

	// final factorial of

	//List<Integer> list = Arrays.asList(1000, 2000, 3000, 4000, 5000, 6000);

	// list.stream().map(x →calulate(x)).toList();

	// list.stream().map(FactorialExamples::calculate).forEach(System.out::println);
	
	
	

	//List<BigInteger> factorials = list.stream().map(FactorialExamples::calculate).collect(Collectors.toList());


	public static BigInteger calculate(int num) {

		BigInteger val = BigInteger.ONE;

		for (int i = 2; i <= num; i++) {

			val = val.multiply(BigInteger.valueOf(i));

		}

		return val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = Arrays.asList(1000, 200, 3300, 4000, 500, 6000, 4000,5000,23000,1200,3230,1200);
		long startTime = System.currentTimeMillis();
		List<BigInteger> factorials = list.stream().map(FactorialExamples::calculate).collect(Collectors.toList());
		
		
		
		long endTime = System.currentTimeMillis();
		
		long startTimeParallel = System.currentTimeMillis();
		List<BigInteger> factorials2 = list.parallelStream().map(x -> {
			System.out.println(Thread.currentThread());
			return calculate(x);

		}).collect(Collectors.toList());
		
		long endTimeParallel = System.currentTimeMillis();

		
		for(BigInteger b:factorials) {
			System.out.println(b);
			System.out.println();
		}
		
		for(BigInteger b:factorials2) {
			System.out.println(b);
			System.out.println();
		}
		
		System.out.println(" total time Stream  " + (endTime - startTime));
		
		System.out.println("total time Parallel Stream " + (endTimeParallel - startTimeParallel));
		//Fork join pool - mainly breaks the task into subtask
		// until minimum task is enough to be solved 
		//when we have to do heavy computational task 
		//

		
		
		//suppose you want to write or update some value from system1 to system 2 
		// All these are indepents value in diffrent objects 
		//Submit all the values with metadata like table value and column name;
		//trigger some work flow when u get the response back 
		//Asyn operation 
		// 1 req take u to updates 60 networks - time 
		//Bulk request - 1000 records 
		// 30ms - 100ms 
		//2 sec   - 2000ms
		
	}

}
