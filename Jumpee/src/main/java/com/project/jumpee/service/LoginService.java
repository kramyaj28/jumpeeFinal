package com.project.jumpee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.project.jumpee.dto.LoginDto;
import com.project.jumpee.exception.AlreadyLoginException;
import com.project.jumpee.exception.UsernameNotExistsException;
import com.project.jumpee.model.User;
import com.project.jumpee.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	public User loginUser(LoginDto loginDto) {

		if(!userRepository.existsByEmail(loginDto.getUsername())){throw new UsernameNotExistsException("");}


		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginDto.getUsername(), loginDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		if(userRepository.existsByStatus(1)) {
			User user = userRepository.getUserByStatus(1);
//			User userEmail = userRepository.findByEmailId(user.getId());
			if(user.getEmail().equals(loginDto.getUsername())) {
				throw new AlreadyLoginException("");
			}
		}

		if(userRepository.existsByStatus(1)) {
			User user = userRepository.getUserByStatus(1);
			user.setStatus(0);
			userRepository.save(user);
		}
		
		User users = userRepository.getUserByEmail(loginDto.getUsername());
		users.setStatus(1);
		userRepository.save(users);
		
		return users;
	}
}