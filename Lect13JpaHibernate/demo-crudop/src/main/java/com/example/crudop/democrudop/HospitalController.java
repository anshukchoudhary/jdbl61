package com.example.crudop.democrudop;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HospitalController {
	
	
	
	@Autowired
	PatientService ps;
	
	
	//You have to create two apis
	//1) to add a new patient
	//http method -- POST
	//Retrun type -- Patient
	//Request Body - Patient
	//url - /createPatient
	//
	
	
	//2) to get the patient by id
	//HTTP METHOD - GET
	//RETURN TYPE - PATIENT
	//PATH VARIALBLE - PATIENT ID
	//URL - /getPaitentDetailsById
	

	
	//What is the flow 
	//Contoller ---> service ----> repo ----> db
	
	//SERVICES - BUSINEES LOGIC
	//REPO - QUIRES OR INTERACTION WITH DB
	//CONTROLLERS- END POINTS
	// MODELS - WILL HOLD THE OBEJCT 
	
	
	@PostMapping("/createPatient")
	public void createPatient(@RequestBody Patient patient) throws SQLException {
		
		if(patient!=null) {
			ps.createPatient(patient);
		}
		

		
	}
	
	
	@GetMapping(value = "/getAllPatientDetails")
    public List<Patient> getPatientDetail() throws SQLException{
		
		//TODO ADD A CALL TO SERVICE
		
		
		return ps.getAllPatient();
		
        //return pObj;
    }
	
	
	//Create another api to update a record
	
	@DeleteMapping(value = "/deletePatient")
    public boolean deletePatient(@RequestParam("id") int id) throws SQLException{
		
		//TODO ADD A CALL TO SERVICE
		
		
		return ps.deletePatient(id);
		
        //return pObj;
    }
	
	
	
	//Hibernate 
	
	//is a java framework used to store the java objects in rdbms 
	//it also called ORM tool
	//it will map the java class to sql table
	//it will also take responsibilty of internally executing query 
	
	
	
	//JPA is an interface -----> hibernate is a implemetor of jpa
	//JPA is kind of standard contract 
	
	//JPA methods - get(), save(), update(), find()
	
	//Hibernate will be implementing all these methods 
	
	//JPA HIBERNATE IS FOR NOSQL AND SQL BOTH ?
	// IT IS ONLY FOR SQL
	
	
	
	
	
	
	

}
