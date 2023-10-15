package com.oopsconcept.examples;

public class SingletonClassExamples {

	// class that can have only one object at a given point of time
	private static SingletonClassExamples singletonClassExamples = null;

	private SingletonClassExamples() {

	}

	public static SingletonClassExamples getInstance() {
		if (singletonClassExamples == null) {
			singletonClassExamples = new SingletonClassExamples();

			System.out.println(singletonClassExamples);
		}

		return singletonClassExamples;

	}
//
//	public static void main(String[] args) {
//
//		SingletonClassExamples obj = new SingletonClassExamples();
//		SingletonClassExamples obj2 = new SingletonClassExamples();
//		SingletonClassExamples obj3 = new SingletonClassExamples();
//		
//		System.out.println(obj.hashCode());
//		System.out.println(obj2.hashCode());
//		System.out.println(obj3.hashCode());
//
////		SingletonClassExamples obj = getInstance();
////		SingletonClassExamples obj2 = getInstance();
////		SingletonClassExamples obj3 = getInstance();
////
////		System.out.println(obj.hashCode());
////		System.out.println(obj2.hashCode());
////		System.out.println(obj3.hashCode());
//
//	}

}
