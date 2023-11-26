package com.example.crudop.democrudop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	private static Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	CrudOpExmples obj;
	
	@Autowired
	DemoConfig demoConfig;

	
	@GetMapping("/getNameDetails")
	public String xyz() {
		//Inside getAllEmployee PersonController  com.example.crudop.democrudop.CrudOpExmples@12312a66
		//Inside EmployeeController               com.example.crudop.democrudop.CrudOpExmples@12312a66
		
		
		
		
		System.out.println("Inside getAllEmployee PersonController  " + obj);
		
		//Inside getAllEmployee PersonController  com.example.crudop.democrudop.CrudOpExmples@7d5a077f
		
		logger.trace("Hi there i am getnamedetails from Logger");
		logger.debug("Hi there i am getnamedetails from Logger");
		logger.info("Hi there i am getnamedetails from Logger");
		logger.warn("Hi there i am getnamedetails from Logger");
		logger.error("Hi there i am getnamedetails from Logger");
		
		return  "getNameDetails, My nmae is Abhishek";
				
	}
	
	
	@GetMapping("/getbeanScopeExample")
	public String exampleBeanScope() {
		
		
		//System.out.println(demoConfig.getConfig());
		return  "bean scope";
				
	}
	
	//How ui mapping works when we hit and api?
	//Purpose of dispatcher servelet - to route the incoming request to a particular controller
	//how can we make controller visible to dispachter servelet ?
	//@RestController 
	//uri to method mapping is done by ?
	//requestMappingHandlerMapping
	
	

}
