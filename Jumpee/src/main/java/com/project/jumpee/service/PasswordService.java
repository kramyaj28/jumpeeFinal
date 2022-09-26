package com.project.jumpee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.jumpee.dto.ChangeResetPasswordDto;
import com.project.jumpee.exception.LoginFirstException;
import com.project.jumpee.exception.LogoutException;
import com.project.jumpee.exception.ConfirmPasswordMatchedException;
import com.project.jumpee.exception.CurrentPasswordMatchedException;
import com.project.jumpee.exception.PasswordNotMatchException;
import com.project.jumpee.exception.UserNotFoundException;
import com.project.jumpee.model.User;
import com.project.jumpee.repository.UserRepository;

@Service
public class PasswordService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public String changePassword(ChangeResetPasswordDto changeResetPasswordDto) {

		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}

		User users = userRepository.getUserByStatus(1);
		users.getStatus();

		if(!passwordEncoder.matches(changeResetPasswordDto.getCurrentPassword(), users.getPassword())) {
			throw new CurrentPasswordMatchedException("");
		}

		if(changeResetPasswordDto.getCurrentPassword().equals(changeResetPasswordDto.getPassword())) {
			throw new ConfirmPasswordMatchedException("");
		}

		if(!changeResetPasswordDto.getPassword().equals(changeResetPasswordDto.getConfirmPassword())) {
			throw new PasswordNotMatchException("");
		}

		users.setPassword(passwordEncoder.encode(changeResetPasswordDto.getPassword()));
		userRepository.save(users);
		return "Password updated.";
	}

	public User resetPassword(ChangeResetPasswordDto changeResetPasswordDto) {

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
