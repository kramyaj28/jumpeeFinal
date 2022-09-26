package com.project.jumpee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.jumpee.model.Order;
import com.project.jumpee.service.CheckoutService;

@RestController
@RequestMapping("/api/auth")
public class CheckoutController {

	@Autowired
	private CheckoutService checkoutService;
	
	@PostMapping("/checkout")
	public ResponseEntity<Order> checkout(@RequestBody Order request) {
		return new ResponseEntity<Order>(checkoutService.checkout(request), HttpStatus.OK);
	}
}
