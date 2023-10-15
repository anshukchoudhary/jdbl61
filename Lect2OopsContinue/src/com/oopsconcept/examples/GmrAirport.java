package com.oopsconcept.examples;

import java.util.ArrayList;
import java.util.List;

public class GmrAirport implements FlightDetails,Interface2  {// this is how java supports multiple inheritance

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GmrAirport obj = new GmrAirport();
		obj.getAvailableSeats();
		
		ArrayList<Integer> obj3 = new ArrayList<>();
		
		obj3.trimToSize();
		
		List<Integer> obj2 = new ArrayList<>();
		
		//obj2.trimToSize();
		
		
		
//		FlightDetails obj2 = new FlightDetails() {
//
//			@Override
//			public String getFlightDetails() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public int getAvailableSeats() {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//
//			@Override
//			public String getFlightTime() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//		};

	}

	@Override
	public String getFlightDetails() {
		// TODO Auto-generated method stub
		return "Air india";
	}

	@Override
	public int getAvailableSeats() {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public String getFlightTime() {
		// TODO Auto-generated method stub
		return "4pm to 6pm";
	}

}
