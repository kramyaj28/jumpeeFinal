package com.project.jumpee.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.jumpee.dto.RegisterDto;
import com.project.jumpee.exception.EmailExistsException;
import com.project.jumpee.exception.MobileNumberExistsException;
import com.project.jumpee.exception.PasswordNotMatchException;
import com.project.jumpee.model.Role;
import com.project.jumpee.model.User;
import com.project.jumpee.model.Wallet;
import com.project.jumpee.repository.RoleRepository;
import com.project.jumpee.repository.UserRepository;
import com.project.jumpee.repository.WalletRepository;

@Service
public class RegistrationService {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private WalletRepository walletRepository;
	
	public User registerUser(RegisterDto request) {

		if(userRepository.existsByEmail(request.getEmail())) {
			throw new EmailExistsException("");
		}

		if(userRepository.existsByMobileNumber(request.getMobileNumber())) {
			throw new MobileNumberExistsException("");
		}
		
		if(userRepository.existsByContactPersonNumber(request.getContactPersonNumber())) {
			throw new MobileNumberExistsException("");
		}

		if(!request.getPassword().equals(request.getConfirmPassword())) {
			throw new PasswordNotMatchException("");
		}

		User user = new User();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		user.setMobileNumber(request.getMobileNumber());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setContactPerson(request.getContactPerson());
		user.setContactPersonNumber(request.getContactPersonNumber());
		Role roles = roleRepository.findByRoleName("USER").get();
		user.setRoles(Collections.singleton(roles));
		userService.registerUser(user);

		//add wallet userId
		if(!walletRepository.existsByUserId(user.getId())) {
			Wallet wallet = new Wallet();
			wallet.setUser(user);
			walletRepository.save(wallet);
		}
		
		return user;
	}

	public RegistrationService(UserService userService, UserRepository userRepository, PasswordEncoder passwordEncoder,
			RoleRepository roleRepository) {
		super();
		this.userService = userService;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.roleRepository = roleRepository;
	}

}
