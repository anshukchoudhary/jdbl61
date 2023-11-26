package com.example.crudop.democrudop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsttructorWayOfDependencyInjection {
	//need of it ?
	//it accesed any where
	//using above annotation
	//it will reduce redunduncy
	//can be used if we have common value to be used accross application
	
	
	//let read about property inject 
	
	
	// @Autowired // field injection
	
	
	//@Autowired 

	//do constructor injection 
	
	
	//int batchNumber=61;
	
	@Value("${jdbl.lecture.number}")
	int lectureNumber;
	

	
	DemoConfig demoConfig;
	
	PatientRepo childClass;
	
	int batchNum;
	int lectNumb;
	
	
	@Autowired
	public ConsttructorWayOfDependencyInjection(PatientRepo childClass, @Value("${jdbl.batch.number}") int batchNumber) {
		this.childClass = childClass;
		
		System.out.println("Hi there property injection is completed lectureNumber " + this.lectureNumber);//12
		//this.loadStudentPanel(lectureNumber);
		//this.loadConfigPanel(batchNumber);
		//this.loadAdminPanel();
		System.out.println("Hi there property injection is completed batchNumber " + batchNumber);//61

	}

	//Hi there property injection is completed lectureNumber 0
	//Hi there property injection is completed batchNumber 61
	

	public ConsttructorWayOfDependencyInjection(DemoConfig demo) {
		this.demoConfig = demo;
		

	}
	


	@GetMapping("/getDetailsByName")
	public String getDetailsByName() {

		//return "bean scope" + demoConfig.getDetails();
		
		return "bean scope" ;

	}

}
