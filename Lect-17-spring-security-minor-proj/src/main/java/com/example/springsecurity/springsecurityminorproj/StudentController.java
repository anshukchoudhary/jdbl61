package com.example.springsecurity.springsecurityminorproj;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

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
