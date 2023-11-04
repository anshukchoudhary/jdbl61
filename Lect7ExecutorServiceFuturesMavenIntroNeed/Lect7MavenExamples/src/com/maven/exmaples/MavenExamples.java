package com.maven.exmaples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MavenExamples {
	
	//Maven - build tools
	//used for banckend java projects
	//JDBC 
	//Can you create table using java application
	//Suppose for exmaple u want to transfer a file - FTP
	//Suppose to email - STMP
	//U WANT to create a db connect in java - jdbc

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//Maven - 3.6.0 - end goal 
//		C:\jdbl61>mvn -version
//		Apache Maven 3.8.4 (9b656c72d54e5bacbed989b64718c159fe39b537)
//		Maven home: C:\Software\apache-maven-3.8.4-bin\apache-maven-3.8.4
//		Java version: 17.0.6, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-17
//		Default locale: en_IN, platform encoding: Cp1252
//		OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
		
		
		//java jdk - free one if u want red hat
//		C:\jdbl61>java -version
//		java version "17.0.6" 2023-01-17 LTS
//		Java(TM) SE Runtime Environment (build 17.0.6+9-LTS-190)
//		Java HotSpot(TM) 64-Bit Server VM (build 17.0.6+9-LTS-190, mixed mode, sharing)
		
		//My workbench install
		
		//Postman
		
		
		
		System.out.println("Create a conenction with db and add a new table");
		
		
		//port number for mysql - 3306
		//port postgre - 5432
		//127.0.0.1 = also called localhost
		//HTTPS PORT - 443
		//HTTP PORT - 80
		//url a database url of the form  jdbc:subprotocol:subname
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentDetails","root","");
		Statement stmnt = con.createStatement();
		stmnt.execute("create table jdbl614thNov(id int, name varchar(20), address varchar(20))");
		
		
		
		

		
		
	}

}
