package com.examples.streamandmultithreading;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FlatMapExamples {

	// map - we get a new stream on the basis of function we apply
	// map - it was one to one transformation
	// for 1 input 1 output

	// flatenning
	// we have multiple list
	// we want to merge these list to create a new list
	// single list
	// flatmap = map() + flatenning;

	// flatmap -
	// this is one to many transfromation
	// result that you get will be trasnfroemd back to flattened output

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numberList = Arrays.asList(1, 53, 3, 4, 55, 51, 32, 122);

		// use of map
		numberList.stream().map(x -> (x%2==0)).forEach(x -> System.out.println(x));

		List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(3, 4, 5, 6),
				Arrays.asList(5, 6, 1, 2), numberList);

		System.out.println(list);

		List<Integer> list2 = list.stream().flatMap(x -> {
			System.out.println(x);
			return x.stream();

		}).toList();
		
		System.out.println("list2" + list2);
		//System.out.println(list);

		List<Integer> list3 = list.stream().flatMap(x -> {
			//System.out.println(x);
			return x.stream();

		}).toList();
		System.out.println("list3" + list3);
	}

}
