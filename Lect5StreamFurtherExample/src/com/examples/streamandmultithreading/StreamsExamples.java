package com.examples.streamandmultithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamsExamples {

	public static void main(String[] args) {
		
		
		
		//Stream - 
		//how to configure - map and filter - intermediate operation 
		//termainal operation - collect, reduce, get,foreach, findfirst, findany
		//tolist
		
		
		List<Integer> numberList = Arrays.asList(1,53,3,4,55,51,32,122);
		
		//List<Integer> numberList2 = new ArrayList<>(Arrays.asList(12,3,4));
		
		
		
//		numberList.stream().filter(x -> {
//			 System.out.println(x);
//						return (x>50);
//						}).forEach(y -> System.out.println("value " + y));
		
		//stream never claim it will be fast than for loop
		//will be almost equal 
		
		
		//Short circuting 
		
		
		Optional<Integer> val = numberList.stream().filter(x -> {
			 System.out.println(x);
						return (x>50);
						}).findFirst();
		
	
		
//		public Person getPerson() {
//			return null
//		}
//		
//		//Person id or age or name 
//		if(Person !=null && Person.id!=null) {
//			Person.id = 12;
//		}
//		
		
		
		//Optional - is kind of or container which can hold values as such empty, value
		//present // empty
		
		//ifPresent - do something when we have value
		//isPresent = true when we have non empty value // false if empty
				
		// int 
		//Integer
		
		//Ways to create optional object in java 
		//of - if value present - return the value // if value is null - return empty object 
		
		Optional obj = Optional.of("");
		
		Optional obj2 = Optional.empty();
		
		
		
		 
		Optional obj5 = Optional.ofNullable("");
		
		System.out.println("3333 checked the nullable value" + obj5.get());
		
		Optional<Integer> obj6 = Optional.ofNullable(23);
		
		if(obj5.isPresent()) {
			System.out.println("checked the nullable value" + obj6.get());
		}
		
		Optional obj3 = Optional.ofNullable(null);
		
		
		 
		
		
		
		if(obj2.isPresent()) {
			System.out.println("val is present");
		}else {
			System.out.println("else val not present");
		}
		
		
		obj.ifPresent(val2 -> System.out.println("do something"));
		
		
		
		//how would you find min and max eleemnt 
		
		List<Integer> numberList3 = Arrays.asList(1,53,3,4,55,51,32,122);
		//step 1 : configure it 
		
		//for
		
		//numberList3.stream().map(x -> x).distinct().forEach(null);
		
		//comparator 
		
		
		//Arrays.sort(numberList3);
		Collections.sort(numberList3);
		
		//syout
		
		//yes it is a terminating operator // reduce // count 
		int max = numberList3.stream().max(Comparator.comparing(Integer::valueOf)).get();
		
		System.out.println(max);
		
		//comparator - when we have to do sorting of objects first sort on age then sort on first name
		//comparable - only id or name or age
		
		
		
		
		
		
		
	

	}

}
