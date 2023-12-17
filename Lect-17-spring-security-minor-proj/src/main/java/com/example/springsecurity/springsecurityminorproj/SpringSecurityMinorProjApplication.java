package com.example.springsecurity.springsecurityminorproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityMinorProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityMinorProjApplication.class, args);
		
		
		
		BCryptPasswordEncoder bcp = new BCryptPasswordEncoder();
		System.out.println(bcp.encode("try@123"));
		System.out.println(bcp.encode("try@321"));
		System.out.println(bcp.encode("try@412"));
	}
	
	//1st iteration 
//	$2a$10$Lncyp8Ri73mGgVWLeeNN7u0TRWKr2qa3H201ZCq4/ORYLnoSRgRaa
//	$2a$10$DWheb8eVzNDXOvswEh2SBe4DqlMN8c4gG9tlqlvd2rzoar9ytjxwu
//	$2a$10$jzo7ZpZy7W3l.RJrz/6LfunG4QfuJE7MZRjbmGO0uc8RKTOdjeH5q
	
	//here 2a represent bcrypt algo
	//10 strength 
	//then we have salt 
	// folowed by hash value 
	
	//total length  - 60
	
	
	
	//2nd iteration 
	//$2a$10$cxzHRcgspgrzJ2Y/IjBQdeQ8QJo0pPTiMB6u3/ojP20eskszJBo4a
	//$2a$10$AwNwWqEiQD2DLlAZrPbBaerQyNOJyjDOZ2XuHlzIRKF/WK3zH7mXW
	//$2a$10$JWHSWHrKEG6DGUVALcFcHeofGP8XINRmcc8VO47IsgM/ygPTqPCPm
	


}
