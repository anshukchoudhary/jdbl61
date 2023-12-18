package com.example.jbdl.demosecuritydb;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequest {
	
	
	@NotBlank
	private String userName;
	
	@NotBlank
	private String passWord;
	
	@NotNull
	private Boolean isDeveloper;
	

}
