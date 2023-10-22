package com.functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.hasmaphashcode.Person;

public class TypesOfFunctionalInterfaces {
	
	
	public static int addOneToEachvalue(int x){
		
		return x + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		System.out.println();
		arr.forEach((n) -> System.out.println(n));

		// Consumer functional interface - this FI states that it can only take
		// something as input or it ca accept somehting
		// it does not return any thing

		Consumer<String> consumer = (c) -> {
			String val = "";
			for (int i = 0; i < 4; i++) {
				val = val + c;
			}
			System.out.println("Val " + val);
		};

		consumer.accept("Divya");

		// Supplier FI - IT ONLY RETURNS SOMETHING and doesnot accepts
		Supplier<String> supplier = () -> "This is the value from supplier FI";

		Supplier<String> supplier2 = () -> UUID.randomUUID().toString();

		System.out.println("supplier2 " + supplier2.get());

		System.out.println(supplier.get());

		// Find the summation of the given element in the array list.

		ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		int sumEven = 0;
		int sumOdd = 0;
		for (Integer e : arr2) {

			if (e % 2 == 0) {
				sumEven += e;
			}else {
				sumOdd +=e;
			}

		}
		System.out.println("Value of the arr is " + sumEven + "Odd value " +  sumOdd);
		
		
		arr2.stream().forEach(x -> System.out.println(x));
		
		arr2.stream().filter(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				return t%2 == 0;
			}
			
		}).forEach(x -> System.out.println("Even number from FI " + x));
		
		
		arr2.stream().filter((n)-> (n%2 == 0)).forEach(t -> System.out.println(t));
		
		arr2.stream().filter((n)-> (n%2 !=0)).forEach(t -> System.out.println(t));
		
		//ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
	
		//OUTPUT 
		System.out.println(arr2.stream().map(x -> {return addOneToEachvalue(x);}).collect(Collectors.toList()));
		
		
		///arr2.stream().fil
		
		//arr2.stream().sorted();
		
		
		List<Person> people  = Arrays.asList( new Person(1,20,"Bikesh","Delhi"),new Person(2,21,"Ana","Delhi2"),
				new Person(3,22,"Bikesh3","Delhi3"),new Person(4,23,"Bikesh4","Delhi4"),new Person(5,25,"Bikesh5","Delhi5"),
				new Person(6,26,"Ana","Delhi6"));
		
		System.out.println("Size of the people object " + people.size());
		
		
		
		//Find the first value of occurence if there are people whose name is Ana
		//findFirst is dependent on type of stream ordered or not;
//		System.out.println("First value of ana -  " + people.stream().filter(x-> x.getName().equals("Anaa"))
//																			.findFirst().get().getName());
//		
		Person person3 = new Person(6,26,"Default","Default");
		
		Optional op = Optional.of(person3);
		
		System.out.println("First value of ana -  " + people.stream().filter(x-> x.getName().equals("Anaa"))
				.findFirst().orElse( new Person(6,26,"Default","Default")));
																			
		
		//
		
		//Find the second highest number 
		ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(1000, 2000, 3000, 4000));
		
		System.out.println(arr4.stream().sorted(Collections.reverseOrder()).skip(1).findFirst());
		
		
		//try with resources with examples and interview
		// try exception handle inheritance 
		//muskan 
		//arun
		//ashwini
		//MOhd firoj
		//shyamal gandhi
		

	}

}
