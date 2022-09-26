package com.project.jumpee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.jumpee.model.Order;
import com.project.jumpee.service.OrderService;

@RestController
@RequestMapping("/api/auth")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/view-order-history")
	public List<Order>	viewOrderHistory() {
		return orderService.viewHistory();
	}
}
