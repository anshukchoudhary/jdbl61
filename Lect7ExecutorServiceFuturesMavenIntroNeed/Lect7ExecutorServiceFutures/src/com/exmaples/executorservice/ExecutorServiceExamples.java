package com.exmaples.executorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class ExecutorServiceExamples {

	///Fork join common pool use work steal algo
	// where if one worker thread finishes it task
	// it will go steal task from other
	// it subdivides the task until the small divide is independelty solvable

	// Async task - mutilple task are taken parallel for execution by different
	// threads
	// Synchornous task - if you are executing something you will wait for it to
	// complete before taking the new task.
	// example - complete task1 and then switch to task 2

	// Executor - is a interface that declares a single method which will excute the
	// task in background

	// Type of executors
	// to create a single thread - SingleThreadExecutors
	// to create thread of some size - Fixed Thread pool

	// ExecutorService - it has more feature or methods and it extends executor
	// interface
	// if you want to schedule the task
	// on the basis of some conditons you want to cancel the task

	// suppose you want to store the result of the completed task which is stored in
	// future

	// Future - it is used to store the result of Asynchronous task or computation
	// its a interface from concurrent package
	// it has methods such as iscancel, get() - blocks indefinelty amount of time
	// it also has is isdone,

	// Given a number caclulate number * number + 1
	// retunr the val

	public static int computeValue(int n) {

		System.out.println("That is thread name " + Thread.currentThread());

		return n * n + 1;

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		int inputNumber = 10;
		Future<Integer> future;

		// ExecutorService obj = Executors.newSingleThreadExecutor();
		// How many thread - 1
		ExecutorService esObj = Executors.newFixedThreadPool(10);
		
		//ExecutorService esObj = new ExecutorService

		future = esObj.submit(() -> computeValue(inputNumber));
		int val = future.get();

		System.out.println("Value of is done --  " + future.isDone());
		
		System.out.println("Output value is " + val);
		
		esObj.shutdown();

	}

}
