package com.example.crudop.democrudop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class PatientRepo {
	
	
	
	private static Logger logger = LoggerFactory.getLogger(PatientRepo.class);
	
	private static Connection con;
	
	
	public PatientRepo() throws SQLException{
		
		 logger.info("Inside PatientRepos constrcutor");
		 System.out.println("hi there ");
		
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_sys", "root", "");
		
		 createTable();
		
	}
	
	
	public void createTable() throws SQLException {
		logger.info("Inside createTable method");
		
		String sqlQuery = "create table if not exists patient_jdbl61( id int primary key auto_increment, name varchar(40), age int, doctorName varchar(50))";
		
		Statement stmnt = con.createStatement();
		boolean val = stmnt.execute(sqlQuery);
		
		logger.info("Table create query val " + val);
		
	}
	
	
	//Statement is an interface 
	
	public void insertPatient(Patient patient) throws SQLException {
		
		logger.info("Inside insertPatient method");
		
		//Dynamic query - is pref becoz only parameter changes so it never needs to compile whole query
		String sqlQueryPatient = "INSERT INTO patient_jdbl61(name,age,doctorName) values(?, ?, ?)" ;
		
		PreparedStatement ps = con.prepareStatement(sqlQueryPatient);
		
		ps.setString(1, patient.getName());
		ps.setInt(2, patient.getAge());
		ps.setString(3, patient.getDoctorName());
		
		int val = ps.executeUpdate();
		
		 ResultSet rs = ps.executeQuery();
		
		logger.info("Patient got inserted with value " + val);
		
		
	}
	
	public List<Patient> getAllPatient() throws SQLException {
		
		String sqlQuery = "Select * from patient_jdbl61";
		
		List<Patient> list = new ArrayList<>();
		
		Statement stmnt = con.createStatement();
		ResultSet rs = stmnt.executeQuery(sqlQuery);
		
		while(rs.next()) {
			
			long pId = rs.getLong("id");
			String pname = rs.getString("name");
			int age = rs.getInt("age");
			String dName = rs.getString("doctorName");
			
			Patient patient = new Patient(pId,pname,age,dName);
			
//			Patient patient = new Patient();
//			patient.setAge(age);
			
			list.add(patient);
				
		}
		
		
		return list;
		
	}


	public boolean deletePatient(int id) throws SQLException {
		
		String sqlQuery = "delete from patient_jdbl61 where id = " + id;
		
		Statement stmnt = con.createStatement();
		int val = stmnt.executeUpdate(sqlQuery);
		
		logger.info("deletePatient id " + id);
		
		if(val > 0) {
			return true;
		}
		
		
		return false;
	}
	
	
	
	
	//DDL ----> Data defination lang - CREATE, ALTER, DROP, SHOW, USE, 
	
	//DML ----> Data manipulation lang - UPDATE, SELECT, INSERT, DELETE
	
	//There are mainly three ways 
	//1) execute ---> will return u a true if result set else false ---> use with select queries

	//2) excuteUpdate ---> it will return u number of row affected, this one u can use with non - select query eg - insert, update, delete
	
	//3) executeQuery ---> this returns u the actual result set eg - can be used with select queries.
	
	
	
	
	
	
	
}
