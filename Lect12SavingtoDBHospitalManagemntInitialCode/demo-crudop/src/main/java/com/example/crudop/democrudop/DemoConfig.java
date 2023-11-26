package com.example.crudop.democrudop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration("myConfig")

public class DemoConfig {

	// @Component - this annotation is used to define our own class as a bean
	// @Bean - This annotaion is used to define beans which are part of java code or
	// source code

	@Bean("bean1")
	public RestTemplate getRestTemplate1() {
		System.out.println("Inside getRestTemplate1 func....");
		return new RestTemplate();

	}
	
	
	@Bean
	@Primary
	public RestTemplate getRestTemplate2() {
		System.out.println("Inside getRestTemplate2 func....");
		return new RestTemplate();

	}
	
	
	public String getDetails() {
		return "Hi There! myname is Anvi";
	}

}
