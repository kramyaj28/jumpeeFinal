package com.project.jumpee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jumpee.exception.LoginFirstException;
import com.project.jumpee.exception.NoOrderHistoryException;
import com.project.jumpee.model.Orders;
import com.project.jumpee.model.User;
import com.project.jumpee.repository.OrderRepository;
import com.project.jumpee.repository.UserRepository;

@Service
public class OrderHistoryService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Orders> viewHistory() {
		
		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}
		
		User user = userRepository.getUserByStatus(1);
		
		if(!orderRepository.existsByUserId(user.getId())) {
			throw new NoOrderHistoryException("");
		}
		
		List<Orders> orderHistory = orderRepository.findAllByUserId(user.getId());
		return orderHistory;
		
	}
}
