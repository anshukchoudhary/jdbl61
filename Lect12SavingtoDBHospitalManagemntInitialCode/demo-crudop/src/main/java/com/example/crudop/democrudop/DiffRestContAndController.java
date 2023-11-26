package com.example.crudop.democrudop;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;



@RestController // == controller + responsebody
//@Controller
public class DiffRestContAndController {
	
	
	
	//@Target ---- ctrl + click @rest controller you can find the details
	
	//@Retention
	//SOURCE - IT WILL DISAPPER AFTER COMPILATION, IT WILL NOT APPEAR IN THE BYTE CODE
	//RUNTIME - THOSE ANNOTATION WHICH ARE DISCARDED BY NONE even after compilation or running it will stay in the code
	//CLASS - these annotation is not required at runtime but will present in the byte code 

	// What is the diff ?
	// @Restcontroller
	// @Controller

	
	
	//hit postman -  json -----> java (@Requestbody)
	//java reponse - java -----> json (@ResponseBody)
	
	
	
	
	@PostMapping(value = "/getDetailsEmployee")
	public void getEmployee(@Valid @RequestBody Employee employee) {

		System.out.println("Inside EmployeeController  ");

		System.out.println("Inside create employee  ");

	}
	
	
	@PostMapping(value = "/getDetailsEmployee2")
	public void getEmployee2(@Valid @RequestBody Employee employee) {

		System.out.println("Inside EmployeeController  ");

		System.out.println("Inside create employee  ");

	}
	
	
	@PostMapping(value = "/getDetailsEmployee3")
	public void getEmployee3(@Valid @RequestBody Employee employee) {

		System.out.println("Inside EmployeeController  ");

		System.out.println("Inside create employee  ");

	}

}
