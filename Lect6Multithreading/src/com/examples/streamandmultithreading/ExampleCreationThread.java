package com.examples.streamandmultithreading;

public class ExampleCreationThread implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		
		
		//54000 //45000 /// 52000 // 120000 // 30000 //12009
		System.out.println("Inside main method : Mythread" + Thread.currentThread());
		
		ExampleCreationThread obj = new ExampleCreationThread();
		Thread th = new Thread(obj);
		//th.run();//becoz run method never creates a new thread 
		//th.sleep(10000);
		th.setPriority(8);
		th.start();//
		
		System.out.println("Inside main method : Mythread" + Thread.currentThread());
		th.sleep(6000);
		
		System.out.println("Thread priority  " + th.getPriority() + th.getName());
		
		
		///th.start();
		
		//Thread priortiy - thread with higher priority will be excecuted first //but not 100% guranteed
	
		//T1 = Priortiy 6
		//T2 = PRIORITY 6
		
	}
	
	//i have only 8 processor or core or cpu in my system 
	//Question - can i create only 8 thread for my java program?
	//1000 thread - is light weight process 


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Inside run method : Mythread" + Thread.currentThread() + " " +  Runtime.getRuntime().availableProcessors());
		
		System.out.println("total memory " + Runtime.getRuntime().totalMemory());
		
	}
	
	
	
	//When does priority of thread comes into priority
	
	//Rest room - movie hall or pvr 
	//r1 ---- r2 -------r3
	//when we have more number of guest than rest room available ?
	//number of guest < number rest room available
	
	
	///deposit of bank // number of counter for cash deposit is 5;
	//we have only 3 people // is there any need of priority 
	

}
