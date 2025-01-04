package com.shabaz.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shabaz.Entity.Users;
import com.shabaz.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	
	public Users findByUser(String username) {
	    Users user = userRepository.findByUsername(username);
	        return user; 
	   
	}


}
