package com.project.jumpee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.jumpee.exception.View;
import com.project.jumpee.model.Cart;
import com.project.jumpee.service.ViewCartService;

@RestController
@RequestMapping("/api/auth")
public class ViewCartController {

	@Autowired
	private ViewCartService viewCartService;
	
	@GetMapping("/view-cart")
	@JsonView(View.Base.class)
	public List<Cart>  cart() {
		return viewCartService.cart();
	}
	
}