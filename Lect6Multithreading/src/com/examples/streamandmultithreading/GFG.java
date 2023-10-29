package com.examples.streamandmultithreading;

import java.util.Optional;

class GFG {
	public static void main(String[] args) {
		String str = null;
		getLength(Optional.ofNullable(null));
	}

	public static void getLength(Optional<String> str) {
		if (str.isPresent()) {
			System.out.println(str.get().length());
		} else {
			System.out.println("String is not present / null");
		}
	}
}