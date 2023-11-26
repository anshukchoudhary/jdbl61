package com.example.crudop.democrudop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {

	long patientId;
	String name;
	int age;
	String doctorName;

}
