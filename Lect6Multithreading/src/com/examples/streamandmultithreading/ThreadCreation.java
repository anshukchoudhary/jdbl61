package com.examples.streamandmultithreading;

public class ThreadCreation {

	// user defined thread - two ways
	// runnable // extends thread

	// runnable is a inter

	// How to create a thread using runnable interface
	// Another example is using extends thread

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadCreation obj = new ThreadCreation();
		
		MyThread thread = obj.new MyThread();
		
		Thread t1 = new Thread(thread);
		t1.start();
		
		

	}

	public class MyThread implements Runnable {

		@Override
		public void run() {
			
			System.out.println("Inside run method : Mythread");

		}

	}
}
