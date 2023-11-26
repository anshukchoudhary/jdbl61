package com.example.crudop.democrudop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GetImageApi2 {
	
	@Autowired
	@Qualifier("bean1")
	RestTemplate rt;
	
	
	//RestTemplate rt = new RestTemplate();
	
	
	@GetMapping(value = "/getImagebyImgId", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getImage(@RequestParam("id") int id,@RequestParam("l") int l, @RequestParam("b") int b) {
		
		String url = "https://picsum.photos/id/" + id + "/" + l + "/" + b;
	
		byte[] respsone = rt.getForObject(url, byte[].class);
		
		return respsone;
	}

}
