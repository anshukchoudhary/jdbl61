package com.example.createapi.demo.createapi61;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestExamples {
	
	@GetMapping(value = "/getNameDetails") // it is used to get some data // no it will not manipulate the data // safe http method
	public String getName() {
		
		return "Name: Preethi, Name 2: Bhoomika, Name 3: Bikas, Name 4: Deepanshu";
		
	}
	
	//Things needed for an api
	//
	
	
	//Request param 
	@PostMapping(value = "/getNameDetails123/{var2}")
	public String getName123(@PathVariable("var2") String name, @RequestParam("name") String name2) {
		
		return name2 + name + "test the request param " + "Name: Preethi, Name 2: Bhoomika, Name 3: Bikas, Name 4: Deepanshu";
		
	}
	
	
	
	//By default request param is required 
	//But we have flexibily to make it optional 
	@PostMapping(value = "/getNameDetails1234")
	public String getName123(@RequestParam("name") String name2) {
		
		return name2 + "test the request param " + "Name: Preethi, Name 2: Bhoomika, Name 3: Bikas, Name 4: Deepanshu";
		
	}
	
	
	///Path variable 
	@PostMapping(value = "/getNameDetails456/{var}")
	public String getName456(@PathVariable("var") String name) {
		
		return name + "from request param " + "Name: Preethi, Name 2: Bhoomika, Name 3: Bikas, Name 4: Deepanshu";
		
	}
	
	
	//Request param 
	//path variable 

}
