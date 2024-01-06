package com.example.unit.test.demounittest;

import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;

public class ExamplesTests {
	
	private MockMvc mockMvc;
	
	//TO CONVERT JSON TO STRING AND STRING TO JSON WE NEED IT
	
	ObjectMapper om = new ObjectMapper();
	
	ObjectWriter ow = om.writer();

	
	

}
