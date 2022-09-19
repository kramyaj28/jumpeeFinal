package com.project.jumpee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jumpee.exception.CartIsEmptyException;
import com.project.jumpee.exception.LoginFirstException;
import com.project.jumpee.model.User;
import com.project.jumpee.model.Cart;
import com.project.jumpee.repository.UserRepository;
import com.project.jumpee.repository.CartRepository;

@Service
public class ViewCartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Cart>  cart() {
		
		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}
		
		User user = userRepository.getUserByStatus(1);
		
		if(!cartRepository.existsByUserId(user.getId())) {
			throw new CartIsEmptyException("");
		}
		
		List<Cart>  cart = cartRepository.getByUserId(user.getId());
		return cart;
	}
}
