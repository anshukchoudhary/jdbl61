package com.example.crudop.democrudop;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PatientService {
	
	
	@Autowired
	PatientRepo pr;
	
	
	public void createPatient(Patient patient) throws SQLException {
		//cal age
		//add logic based on pateint age
		//or any businees logic 
		if(patient.getAge() > 0) {
		pr.insertPatient(patient);
		}
		
		
		
	}
	
	
	public List<Patient> getAllPatient() throws SQLException {

		return pr.getAllPatient();
		
	}


	public boolean deletePatient(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		return pr.deletePatient(id);
	}

	
	
	
}
