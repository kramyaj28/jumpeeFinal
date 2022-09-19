package com.project.jumpee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jumpee.exception.LoginFirstException;
import com.project.jumpee.model.User;
import com.project.jumpee.repository.UserRepository;

@Service
public class LogoutService {

	@Autowired
	private UserRepository userRepository;

	public String logoutUser(User user) {
		
		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}
		
		User users = userRepository.getUserByStatus(1);
		users.setStatus(0);
		userRepository.save(users);
		
		return "Logout sucessfully.";
	}
}