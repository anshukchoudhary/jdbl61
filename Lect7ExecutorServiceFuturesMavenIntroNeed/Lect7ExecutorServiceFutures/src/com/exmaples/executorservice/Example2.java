package com.exmaples.executorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

public class Example2 {

	public static int computeValue(int n) {

		System.out.println("That is thread name " + Thread.currentThread());

		return n * n + 1;

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		int inputNumber = 10;
		
		List<Integer> al = Arrays.asList(1,2,3,4,78,16,45);
		ExecutorService esObj = Executors.newFixedThreadPool(10);
		
		//a steeam must and must have a terminal operation 
		//terminal - collect , count , foreach
		al.stream().forEach(x -> esObj.submit(() -> computeValue(x)));
		
		//Collect them all and then print them.
		//Try out exception handling with inherited class
		
		//My task to provide u with - multihtreading, streams, volatile, synchornaztion
				


	}

}
