package com.example.springsecurity.springsecurityminorproj;

import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;



@Configuration
@EnableWebSecurity
public class StudentConfig  extends WebSecurityConfigurerAdapter{
	
	
	
	//configure
	
	//responsibilty for this class is to provide authenticaion
	
	//we are trying to design the ant matcher or adding filter for api 
	 String DEVELOPER_AUTHORITY = "developer";
     String DEVOPS_AUTHORITY = "devops";
     //AuthenticationManagerBuilder - provides diff methods that we can apply for authentication
     //various types of authentication - In memory auth - no db is involved
     //db way of auth - we are saving details of the usr in db
     //ldap auth - it stores or validated user based on hierarchy 
     
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
// here we are going to have user and password detailsof the user 
    	
    	auth.inMemoryAuthentication()
    		.withUser("Arun")
    		.password("$2a$10$Lncyp8Ri73mGgVWLeeNN7u0TRWKr2qa3H201ZCq4/ORYLnoSRgRa")
    		.authorities(DEVELOPER_AUTHORITY)
    		.and()
    		.withUser("khusboo")
    		.password("try@321")
    		.authorities(DEVOPS_AUTHORITY)
    		.and()
    		.withUser("farooq")
    		.password("try@412")
    		.authorities(DEVELOPER_AUTHORITY,DEVOPS_AUTHORITY);	
    	
    }
    
    
    
    //when ever u write and ant matcher it should be from most restrictive to least restrictive 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	// TODO Auto-generated method stub
    	http.httpBasic()
    	.and()
    	.authorizeHttpRequests()
    	.antMatchers("/devops/**").hasAnyAuthority(DEVOPS_AUTHORITY)
    		.antMatchers(HttpMethod.POST, "/developer/**").hasAnyAuthority(DEVOPS_AUTHORITY)

    	.antMatchers(HttpMethod.POST, "/sre/**").hasAnyAuthority(DEVELOPER_AUTHORITY)

    	.antMatchers("/developer/**").hasAnyAuthority(DEVELOPER_AUTHORITY)// developer will have access to both get and post
    
    	.antMatchers("/**").permitAll()
    	.and().formLogin();
    }
	 
	 
//	 
//	 @Bean
//	 public PasswordEncoder getPE() {
//		return NoOpPasswordEncoder.getInstance();
//		 
//	 }
//	 
	 
	 
	 
	 @Bean
	 public PasswordEncoder getPE() {
		return new BCryptPasswordEncoder();
		 
	 }
	 

	

}
