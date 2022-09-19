package com.project.jumpee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.jumpee.dto.ChangeResetPasswordDto;
import com.project.jumpee.exception.LogoutException;
import com.project.jumpee.exception.PasswordNotMatchException;
import com.project.jumpee.exception.UserNotFoundException;
import com.project.jumpee.model.User;
import com.project.jumpee.repository.UserRepository;

@Service
public class ResetPasswordService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User resetPasswordByEmail(ChangeResetPasswordDto changeResetPasswordDto) {
		
		if(userRepository.existsByStatus(1)) {
			throw new LogoutException("");
		}
		
		User existingUser = userRepository.findByEmail(changeResetPasswordDto.getEmail()).orElseThrow(() -> new UserNotFoundException(""));
		
		if(!changeResetPasswordDto.getPassword().equals(changeResetPasswordDto.getConfirmPassword())) {
			throw new PasswordNotMatchException("");
		}
		
		passwordEncoder.encode(changeResetPasswordDto.getPassword());
		userRepository.save(existingUser);
		return existingUser;
	}
}
