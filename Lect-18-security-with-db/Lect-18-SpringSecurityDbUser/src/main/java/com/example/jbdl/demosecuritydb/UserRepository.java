package com.example.jbdl.demosecuritydb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<MyUser, Integer> {
	
		MyUser findByUserName(String name);
		//userName
}
