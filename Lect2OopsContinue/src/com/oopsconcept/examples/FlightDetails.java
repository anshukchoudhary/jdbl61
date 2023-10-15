package com.oopsconcept.examples;

public interface FlightDetails {

	//contrract which will be implemeted by the class needed
	//by default all the method will be public and abstract
	////abstract method will never have a body
	
	String getFlightDetails();

	int getAvailableSeats();

	String getFlightTime();
	
	//java 7 onwards this capabitly was added  of daefault and static
	
	default int getPersonCount() {
		return 12;
		
	}
	
	default int getPersonCoun2t() {
		return 12;
		
	}
	
	static Double getPersonLuggageCount() {
		return 12 * 2.0;
	}
	
	private Double getVal() {
		return 9.0;
		
	}
	
	
	
	

}
