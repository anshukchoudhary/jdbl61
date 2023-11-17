package com.example.createapi.demo.createapi61;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // it ensures that when some body tries to access the resource with api end point it will serve it 
public class RestApiExamples {
	
	
	
	//To create a api
	//HTTP METHOD - GET OR PUT OR POST or patch 
	//METHOD - METHOD NAME
	//
	
	@GetMapping(value = "/getNameDetails22") // it is used to get some data // no it will not manipulate the data // safe http method
	public String getName() {
		
		return "Name: Preethi, Name 2: Bhoomika, Name 3: Bikas, Name 4: Deepanshu";
		
	}
	

	@PostMapping(value = "/getNameDetails") // suppose u want to create a new resource or create a new student obj and save ot db // unsafe method
	public String postName() {
		
		return "Name: Preethi, Name 2: Bhoomika, Name 3: Bikas, Name 4: Deepanshu";
		
	}
	
	//student - name , age , address, lname

	@PutMapping(value = "/getNameDetails")//this is used to update the full resouce or object 
	public String putName() {
		
		return "Name: Preethi, Name 2: Bhoomika, Name 3: Bikas, Name 4: Deepanshu";
		
	}
	

	@PatchMapping(value = "/getNameDetails")// is to update partial object - address
	public String patchName() {
		
		return "Name: Preethi, Name 2: Bhoomika, Name 3: Bikas, Name 4: Deepanshu";
		
	}
	
	
	
	
	

}
