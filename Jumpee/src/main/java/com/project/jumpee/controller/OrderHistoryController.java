package com.project.jumpee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.jumpee.model.Orders;
import com.project.jumpee.service.OrderHistoryService;

@RestController
@RequestMapping("/api/auth")
public class OrderHistoryController {

	@Autowired
	private OrderHistoryService orderHistoryService;
	
	@GetMapping("/view-order-history")
	public List<Orders>	viewOrderHistory() {
		return orderHistoryService.viewHistory();
	}
}
