package com.project.jumpee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.jumpee.model.Orders;
import com.project.jumpee.model.Cart;
import com.project.jumpee.service.CheckoutService;

@RestController
@RequestMapping("/api/auth")
public class CheckoutController {

	@Autowired
	private CheckoutService checkoutService;
	
	@PostMapping("/checkout")
	public Cart checkout(@RequestBody Orders request) {
		return checkoutService.checkout(request);
	}
}
