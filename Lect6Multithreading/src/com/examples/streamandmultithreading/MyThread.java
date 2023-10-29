package com.examples.streamandmultithreading;

public class MyThread extends Thread{
	
	
	private boolean isDeposit;
	
	private Double amount;
	
	private BankAccount bankAccount;
	
	MyThread(boolean isDeposit, Double amount, BankAccount bankAccount){
		
		this.isDeposit = isDeposit;
		this.amount = amount;
		this.bankAccount = bankAccount;
	}
	
	
	
	@Override
	public void run() {
		
		//Entry section
		System.out.println("Inside run method : Mythread");
		
		
		
		synchronized(bankAccount) { //CRITICAL SECTION
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("exmaple 51 ");
		if(isDeposit) {
			bankAccount.depositAmount(this.amount);
			
		}else {
			bankAccount.deductBalance(this.amount);
		}
		
		}
		
		//Remainder section
		
		System.out.println("Inside run method : Mythread23 remainder ");
		

	}

	
}
