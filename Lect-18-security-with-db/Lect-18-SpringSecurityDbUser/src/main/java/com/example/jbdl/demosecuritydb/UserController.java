package com.example.jbdl.demosecuritydb;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Value("${user.authority.developer}")
	private String DEVELOPER_AUTHORITY;
	
	
	@Value("${user.authority.devops}")
	private String DEVOPS_AUTHORITY;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	
	@PostMapping("/signup")
	public void createNewUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
		
		
		MyUser myUser = MyUser.builder()
				.userName(userCreateRequest.getUserName())
				.password(passwordEncoder.encode(userCreateRequest.getPassWord()))
				.authorities(userCreateRequest.getIsDeveloper() ? DEVELOPER_AUTHORITY : DEVOPS_AUTHORITY).build();
		
		userService.createUser(myUser);
		
		
		
	}

    
	
	@GetMapping("/devops")
	public String devops() {

		return "Hi Devops !!!";
	}

	@PostMapping("/sre")
	public String sre() {

		return "Hi sre !!!";
	}

	@GetMapping("/tester")
	public String tester() {

		return "Hi tester !!!";
	}

	@GetMapping("/developer")
	public String developer() {

		return "Hi Developer !!";
	}
	
	
	@PostMapping("/developer")
	public String developerDetails() {

		return "Hi Developer !!";
	}
 
  

}
