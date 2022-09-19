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
public class UpdateOtherDetailsService {

	@Autowired
	private OtherDetailsRepository otherDetailsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public OtherDetails updateOtherDetails(OtherDetailsDto request) {
		
		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}
		
		User users = userRepository.getUserByStatus(1);
		
		if(!otherDetailsRepository.existsByUserId(users.getId())) {
			throw new NoDataException("");
		}
		
		User user = userRepository.getUserByStatus(1);
		OtherDetails otherDetails = otherDetailsRepository.findByUserId(user.getId());
		otherDetails.setAddress1(request.getAddress1());
		otherDetails.setAddress2(request.getAddress2());
		otherDetails.setAddress3(request.getAddress3());
		otherDetails.setContactPerson(request.getContactPerson());
		otherDetails.setContactPersonNumber(request.getContactPersonNumber());
		otherDetailsRepository.save(otherDetails);
		return otherDetails;
	}
	
	
}
