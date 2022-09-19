package com.project.jumpee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jumpee.exception.LoginFirstException;
import com.project.jumpee.exception.NoDataException;
import com.project.jumpee.model.OtherDetails;
import com.project.jumpee.model.User;
import com.project.jumpee.repository.OtherDetailsRepository;
import com.project.jumpee.repository.UserRepository;

@Service
public class ViewUserOtherDetailsService {

	@Autowired
	private OtherDetailsRepository otherDetailsRepository;

	@Autowired
	private UserRepository userRepository;

	public List<OtherDetails> getUserDetails() {

		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}

		User users = userRepository.getUserByStatus(1);

		if(!otherDetailsRepository.existsByUserId(users.getId())) {
			throw new NoDataException("");
		}

		User user = userRepository.getUserByStatus(1);
		List<OtherDetails> userDetails = otherDetailsRepository.getByUserId(user.getId());
		return userDetails;
	} 

}
