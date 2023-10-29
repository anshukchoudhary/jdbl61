package com.examples.streamandmultithreading;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FTSubmitManual {

    public static void main(String[] args) {
        //List<Integer> al = Arrays.asList(10000, 20000, 30000, 50000, 23000, 56000, 45000, 50000, 70000, 48000, 54000);

        
        List<Integer> al = Arrays.asList(1,2,3,4000,5,6,7,8);
 
        MyThread[] threads = new MyThread[al.size()];// why are we taking array of threads - we want each of the computation done in diff thread

        long start = System.currentTimeMillis();

        FTSubmitManual o = new FTSubmitManual();

        //for Wrapper of diff type we have Integer, Double
        //for primitve here we have Instream
        IntStream.range(0, al.size()).forEach(i -> {
        	//System.out.println("Here from thread number i");
            threads[i] = o.new MyThread(al.get(i));// where is the value i am passing 
            threads[i].start(); //

        });
        
        //join method puts current thread on to wait until the thread execution is terminated

        Arrays.stream(threads).forEach(x -> {
            try {
                x.join();
        	System.out.println("Here from thread number " + x);
                System.out.println(x.result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long end = System.currentTimeMillis();

        System.out.println("Time taken : " + (end - start));
    }

    private class MyThread extends Thread {

          private int num;
          private BigInteger result;
//
        public MyThread(int num) {
            this.num = num;
            this.result = BigInteger.ONE;
        }

        @Override
        public void run() {
            try {
				calculate(this.num);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        private BigInteger calculate(int num) throws InterruptedException{
        	//Thread.sleep(5000);
            System.out.println("In calculate fn for num " + num +
                    ", thread " + Thread.currentThread().getName());

            for(int i = 2; i <= num; i++){
                this.result = this.result.multiply(BigInteger.valueOf(i));
            }

            return this.result;
        }
    }
}