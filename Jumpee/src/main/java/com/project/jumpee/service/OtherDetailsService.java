package com.project.jumpee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jumpee.exception.DataAlreadyExistsException;
import com.project.jumpee.exception.LoginFirstException;
import com.project.jumpee.exception.MobileNumberExistsException;
import com.project.jumpee.model.OtherDetails;
import com.project.jumpee.model.User;
import com.project.jumpee.repository.OtherDetailsRepository;
import com.project.jumpee.repository.UserRepository;

@Service
public class OtherDetailsService {

	@Autowired
	private OtherDetailsRepository otherDetailsRepository;

	@Autowired
	private UserRepository userRepository;

	public OtherDetails saveDetails(OtherDetails request) {

		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}

		User user = userRepository.getUserByStatus(1);

		if(otherDetailsRepository.existsByUserId(user.getId())) {
			throw new DataAlreadyExistsException("");
		}
		
		if(otherDetailsRepository.existsByContactPersonNumber(request.getContactPersonNumber())) {
			throw new MobileNumberExistsException("");
		}

		OtherDetails otherDetails = new OtherDetails();
		otherDetails.setAddress1(request.getAddress1());
		otherDetails.setAddress2(request.getAddress2());
		otherDetails.setAddress3(request.getAddress3());
		otherDetails.setContactPerson(request.getContactPerson());
		otherDetails.setContactPersonNumber(request.getContactPersonNumber());
		otherDetails.setUser(user);
		otherDetailsRepository.save(otherDetails);
		return otherDetails;
	}

}
