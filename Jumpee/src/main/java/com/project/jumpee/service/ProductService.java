package com.project.jumpee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.jumpee.exception.LoginFirstException;
import com.project.jumpee.model.Product;
import com.project.jumpee.repository.ProductRepository;
import com.project.jumpee.repository.UserRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Page<Product> sortPage(Pageable page) {
		
		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}
		
		return productRepository.findAll(page);
	}
	
	public List<Product> search(String keyword) {
		
		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}
		
		return productRepository.search(keyword);
	}
	
	
}
