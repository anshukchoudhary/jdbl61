package com.example.gfg.jdblmavenexamples61;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jdblmavenexamples61Application {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Jdblmavenexamples61Application.class, args);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentDetails","root","");
		Statement stmnt = con.createStatement();
		//stmnt.execute("create table jdbl61MvnSpringBoot(id int, name varchar(20), address varchar(20))");
		//mmmmm
		
		
		//How maven resolves the dependency 
		//1) Local repo - .m2
		//2) Remote repo - common for a group of people  - it is refered for suppose org 
		//3) Central repo - mvn repo
		
		//Life cylce that maven has
		//1) clean - it deletes the target folder 
		//2) validate - check like if the code base is proper in pom.xml
		
		//3) compile - will compile entire code in the main folder and will create the byte code
		
		//4) Test = it run only in test folder 
		
		//5) package - it is responsible to create a jar file of project 
		// it will add it to target folder 
		//but will not push this jar to local repo
		
		
		//6)mvn install  - 
		
		
		
		//API 
		//URL = BASE URL + API ENDPOINT 
		//api - application program interface
		//it is contract b/w front end and backend 
		//to acheived or do or perfom any operation 
		//suppose u want to search something 
		///search/video/getVideoById
		//search/video/getVideoByName
		//When ever there is empty space then are special characters are used to append 
		//as url can not have empty space
		//HTTP METHOD - GET
		
		
		//https     
		//its is protocol used to access data on internet.
		//port number - 443
		//secure 
		//encyrption of data is done 
		//Transport layer
		
		
		//HTTP 
		//it use also used to access data
		// 80
		//not encrypted 
		//unsecure
		//application layer 
		
		
		
		
		
		
	}

}
