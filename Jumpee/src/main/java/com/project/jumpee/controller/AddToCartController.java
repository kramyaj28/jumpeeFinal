package com.project.jumpee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.jumpee.exception.View;
import com.project.jumpee.model.Cart;
import com.project.jumpee.service.AddToCartService;

@RestController
@RequestMapping("/api/auth")
public class AddToCartController {

	@Autowired
	private AddToCartService addToCartService;
	
	@JsonView(View.Base.class)
	@PostMapping("/add-to-cart")
	public ResponseEntity<Cart> addToCart(@RequestBody Cart request) {
		return new ResponseEntity<Cart>(addToCartService.addToCart(request),HttpStatus.CREATED);
	}
}
