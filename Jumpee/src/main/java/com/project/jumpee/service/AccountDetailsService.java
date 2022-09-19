package com.project.jumpee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jumpee.exception.LoginFirstException;
import com.project.jumpee.model.User;
import com.project.jumpee.repository.UserRepository;

@Service
public class AccountDetailsService {

	@Autowired
	private UserRepository userRepository;

	public User getUserDetails () {
		
		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}
		
		User users = userRepository.getUserByStatus(1);
		users.getStatus();
		users.getFirstName();
		users.getLastName();
		users.getEmail();
		users.getMobileNumber();
		return users;
	}

}