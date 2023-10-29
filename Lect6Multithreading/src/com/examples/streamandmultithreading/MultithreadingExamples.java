package com.examples.streamandmultithreading;

public class MultithreadingExamples {

	public static void main(String[] args) {
		
		//how many core - 1 
		//One task can only begin before precedding is completed
		//they will never run at same time
		//they might be veryfast becoz of context switching
		
		//multiple core case
		//its is ability to exceute independent task at same instant of time
		
		
		
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		//Thread[main,5,main]
		//name of the thread 
		//it is priority of the thread
		//3rd part is group
		
		
		//groupname - where the thread was launched from. when ever you create a thread it attaches a group to it 
		//priority - elite customer should be attended or first asap
		
//		System.out.println(Thread.currentThread().getThreadGroup());
//		System.out.println(Thread.currentThread().getName());
//		System.out.println(Thread.currentThread().getPriority());
//		System.out.println(Thread.currentThread());

	}

}
