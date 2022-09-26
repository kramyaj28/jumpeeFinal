package com.project.jumpee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jumpee.dto.AddressDto;
import com.project.jumpee.exception.LoginFirstException;
import com.project.jumpee.model.Address;
import com.project.jumpee.model.User;
import com.project.jumpee.repository.AddressRepository;
import com.project.jumpee.repository.UserRepository;

@Service
public class AccountDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	public User viewAccountDetails () {
		
		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}
		
		User user = userRepository.getUserByStatus(1);
		return user;
	}
	
	public Address addAddress(Address request) {

		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}

		User user = userRepository.getUserByStatus(1);

		Address address = new Address();
		address.setAddress(request.getAddress());
		address.setUser(user);
		addressRepository.save(address);
		return address;
	}
	
	public List<Address> viewAddress() {
		User user = userRepository.getUserByStatus(1);
		List<Address> addresses = addressRepository.getByUserId(user.getId());
		return addresses;
	}
	
	public Address editAddress(AddressDto request) {
		User user = userRepository.getUserByStatus(1);
		Address address = addressRepository.findByAddressId(user.getId(), request.getAddressId());
		address.setAddress(request.getAddress());
		addressRepository.save(address);
		return address;
	}
	
	public void deleteAddress(long addressId) {
		User user = userRepository.getUserByStatus(1);
		addressRepository.deleteAddress(user.getId(), addressId);
	}
	
	public void setDefaultAddress(long addressId) {
		User user = userRepository.getUserByStatus(1);
		addressRepository.setDefaultAddress(user.getId(), addressId);
	}

	
}