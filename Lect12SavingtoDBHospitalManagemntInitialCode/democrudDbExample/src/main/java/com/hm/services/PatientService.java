package com.hm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.model.Patient;
import com.hm.repos.PatientRepos;

@Service
public class PatientService {
	
	
	@Autowired
	PatientRepos pr;
	
	
	public void createPatient(Patient patient) {
		//cal age
		//add logic based on pateint age
		//or any businees logic 
		if(patient.getAge() > 0) {
		pr.insert(patient);
		}
		
		
		
	}

}
