package com.hm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hm.model.Patient;
import com.hm.services.PatientService;

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
	public void createPatient(@RequestBody Patient patient) {
		
		if(patient!=null) {
			ps.createPatient(patient);
		}
		

		
	}
	
	
	@GetMapping(value = "/getPatientDetailById/{id}")
    public void getPatientDetail(@PathVariable("id") Integer pId){
		
		
        //return pObj;
    }
	
	
	

}
