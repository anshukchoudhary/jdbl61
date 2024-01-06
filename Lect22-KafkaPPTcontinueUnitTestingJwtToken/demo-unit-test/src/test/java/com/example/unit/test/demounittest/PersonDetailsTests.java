package com.example.unit.test.demounittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonDetailsTests {
	
	
	PersonDetails personDetails;
	
	@Test
	public void addAgeFoTwoPerson() {
		personDetails = new PersonDetails();
		assertEquals(13, personDetails.addAgeTwoPerson(6, 7));
	}
	
	
	@Test
	public void addPerson() {
		personDetails = new PersonDetails();
		assertEquals(201, personDetails.addAgeTwoPerson(190, 11));
		
	}

}
