package com.oops.examples;



class Animal {

	  // default or no-arg constructor of class Animal
	  Animal() {
	    System.out.println("I am an animal");
	  }
	}

	class Dog extends Animal {

	  // default or no-arg constructor of class Dog
	  Dog() {

	    // calling default constructor of the superclass
	    super();

	    System.out.println("I am a dog");
	  }
	}

public	class Main {
	  public static void main(String[] args) {
	    Dog dog1 = new Dog();
	  }
	}