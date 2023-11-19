package com.example.crudop.democrudop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration("myConfig")
//@Scope("singleton")// this effort is waste
@Scope("prototype")
public class DemoConfig {
	
	//Singleton - only one object can be created 
	//for singleton object is created in the beginning itself irrescpective of wether it is autwired or not 
	
	
	//prototype - multiple object can be created
	//the object is craeted when it is required or autowired by some class
	

	public DemoConfig() {
		System.out.println("in demo config constructor");
		
	}
	
	public static String getConfig() {
		
		return "Config:: " + "This is default config please refactor later";
		
	}
	
	

}
