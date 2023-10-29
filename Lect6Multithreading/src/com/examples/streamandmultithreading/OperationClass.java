package com.examples.streamandmultithreading;

public class OperationClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Inside OperationClass");
		BankAccount bankAccount = new BankAccount(1, "jdbl_61", 5000.0);
		
		
		BankAccount bankAccount2 = new BankAccount(2, "jdbl_62", 5200.0);
		
		//Fork join is widely used in completeble future and paralel stream.
		//actual output  = 5100
		MyThread t1 = new MyThread(true, 500.0, bankAccount);
		MyThread t2 = new MyThread(false, 400.0, bankAccount);
		
		t1.start();
		
		t2.start();
		
		t1.join();
		t2.join();
		
		
		System.out.println("Current balance " + bankAccount.getBalance());

	}

}
