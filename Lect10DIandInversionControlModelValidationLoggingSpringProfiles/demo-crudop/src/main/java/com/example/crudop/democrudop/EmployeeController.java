package com.example.crudop.democrudop;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


@RestController("mycontrollerProd")
public class EmployeeController {
	
	
	@Autowired
	CrudOpExmples obj;
	
	
	// below annotation are specialiazation of @component 
	
	//suppose u want to create a controller --> @RestController
	//business logic should be written in --> @Service
	//for repo file or logic --> @Repository
	//
	
	
	
	
	
	
	
	//for which all classes bean or object is created by spring boot
	
	//all those classes which are having annotation with @Component on the top it directly or indriectly 

	//we can not call non-static method 
	//is there any object calling these method - yes spring is creating 
	
	//Who is creating this object - Spring 
	
	
	
	
	//1) CRUD
	
	//API 1 - creation of employee //HTTP METHOD - POST
	
	//Add a new employee - 
	//input : Employee details
	//output : void or you want to return the emp object that got saved 
	
	
	private static int count = 1;
	private HashMap<Integer,Employee> empMap = new HashMap<>();
	
	
	
	//name designation, age
	
	@PostMapping(value="/createEmployee")
	public void createEmployee(@Valid @RequestBody Employee employee) {
	
		
		System.out.println("Inside EmployeeController  " + obj);
		
		
		
		
		
//		Employee obj = new Employee();
//		obj.setAge(12);
		
		//if(employee.getName()!= null && employee.getAge()>0 && employee.getDesignation()!= null) {
		
		System.out.println("Inside create employee  " + this);
			
		employee.setId(count++);
		empMap.put(employee.getId(), employee);
		
	
	}
	
	@GetMapping("employee/get/all")
	public List<Employee> getAllEmployee() {
		System.out.println("Inside getAllEmployee  " + this);
		return  empMap.values().stream().collect(Collectors.toList());
				
	}
	
	
	//HW 
	//COMPLETE ALL OTHER API 
	
	
	
	
	
	//API 2 - get details of employee // HTTP METHOD - GET
	//input : emp id 
	//ouput : emp object or emp details u want to show 
	
	//separate api //API 5
	//GET all the employes active or inactive 
	//input : ?
	//output : Employees List
	
	
	
	//API 3 - update details of employee //HTTP METHOD - PUT OR PATCH
	//input: id , and the details to be updated 
	//ouput:  return emp object based on ID 
	
	//API 4 - delete details of employee  //HTTP METHOD - DELETE
	//input - id 
	//output - employee details , boolean true or false if emp was delted or not
	
	
	
	
}
