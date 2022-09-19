package com.project.jumpee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jumpee.exception.LoginFirstException;
import com.project.jumpee.model.Product;
import com.project.jumpee.model.User;
import com.project.jumpee.model.Cart;
import com.project.jumpee.repository.ProductRepository;
import com.project.jumpee.repository.UserRepository;
import com.project.jumpee.repository.CartRepository;

@Service
public class AddToCartService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public Cart addToCart(Cart request) {
		
		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}
		
		User user = userRepository.getUserByStatus(1);
		Product productInfo = productRepository.findById(request.getProductId());
		float totalProductPrice = productInfo.getPrice();
		int quantity = request.getQuantity();
		request.setUserId(user.getId());;
		request.setProductId(productInfo.getId());
		request.setQuantity(quantity);
		request.setTotalAmount(totalProductPrice * quantity);
		request.setPaymentStatus((byte) 0);
		request.setCheckOutStatus((byte)0);
		cartRepository.save(request);
		return request;
	}	
}
