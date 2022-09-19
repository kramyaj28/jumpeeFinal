package com.project.jumpee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jumpee.dto.OtherDetailsDto;
import com.project.jumpee.exception.LoginFirstException;
import com.project.jumpee.exception.NoDataException;
import com.project.jumpee.model.OtherDetails;
import com.project.jumpee.model.User;
import com.project.jumpee.repository.OtherDetailsRepository;
import com.project.jumpee.repository.UserRepository;

@Service
public class DeleteOtherDetailsService {

	@Autowired
	private OtherDetailsRepository otherDetailsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public String deleteOtherDetails(OtherDetailsDto request) {
		
		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}
		
		User users = userRepository.getUserByStatus(1);
		
		if(!otherDetailsRepository.existsByUserId(users.getId())) {
			throw new NoDataException("");
		}
		
		OtherDetails otherDetails = otherDetailsRepository.findByUserId(users.getId());
		otherDetailsRepository.delete(otherDetails);
		return "Details deleted.";
	}
	
	
}
