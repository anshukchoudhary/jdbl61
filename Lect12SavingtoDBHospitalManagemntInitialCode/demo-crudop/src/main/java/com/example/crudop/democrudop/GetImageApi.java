package com.example.crudop.democrudop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GetImageApi {
	
	
	
	@Autowired
	//@Qualifier("bean2")
	RestTemplate rt;
	
	//RestTemplate rt = new RestTemplate();

	//Given api lorem picsum // https://picsum.photos/id/237/200/300
	//create an api to get the images 
	//pass the id - 
	//pass the length and breadth 
	//HTTP METHOD 
	//JS - HTTP CLIENT 
	//JAVA - WebClient OR RestTemplate
	
	
	//repsone that we got at start is byte code 
	//consumes - type of data your api will consumes
	//produces - type of data you want to produces
	
	
	
	
	
	
	@GetMapping(value = "/getImagebyId", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getImage(@RequestParam("id") int id,@RequestParam("l") int l, @RequestParam("b") int b) {
		
		String url = "https://picsum.photos/id/" + id + "/" + l + "/" + b;
	
		byte[] respsone = rt.getForObject(url, byte[].class);
		
		return respsone;
	}
	
	
	
	
	
}
