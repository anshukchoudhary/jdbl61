package com.example.createapi.demo.createapi61;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApis {
	
	
	//REST  - Representational state trasnfer 
	//Rest api - Stateless 
	
	//user1 ----> website ----> backend 
	//ui will not store any info 
	
	//user -- access some website -- do want to login again an again
	//user----  FRONTEND CODE ----- BACKEND CODE 
	
	//Shopkeeper - u go every day and try to buy some vegetables
	//500 -- 10%
	// the vegetable buyer  ------>       shopkeeper (backend)
	
	//if there is no need to maintain the state of info from one req to another then we should use REST
	//works with - 
	
	
	//SQL --- rdbms ---- MYSQL DB , ORACLE , POSTGRES
	//NOSQL --- dont have any relations --- Mongodb, Cassandra , 
	
	
	
	//Two diff - 
	//node  - java script framework - nosql - collection of news paper data  - unsctrucutred 
	// spring boot - rdbms - Transactions
	//@Transctonal 
	//isolation - req
	
	
	
	
	
	
	
	//SOAP - Simple object access protocol 
	//Statefull 
	//info will be persisted 
	//when we have to preserve the state 
	
	
	//Q come up with real time exmaple for soap 
	
	
	
	@GetMapping(value = "/getNames333") 
	public String postName() {
		int a = 1/0;
		
		return "Name: Preethi, Name 2: Bhoomika, Name 3: Bikas, Name 4: Deepanshu";
		
	}
	
	//200 -- all good success
	//500 -- internal server error - request is reaching backend but having some error while code execution
	//404 - api we are trying to hit is unavalaible or not present or not found 
	//401 - unauthorized - you are not a valid user 
	//403 - forbidden -  that u are a valid user but you dont have permission to do some specfic task
	
	//405 - when we are trying to access the api with wrong http method 
	
	
	
	//suppose if you have down time server1 is down - redirect my page to   --- dog pic or any sorry page  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
