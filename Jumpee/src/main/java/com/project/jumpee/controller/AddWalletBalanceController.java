package com.project.jumpee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.jumpee.exception.View;
import com.project.jumpee.model.Wallet;
import com.project.jumpee.service.AddWalletBalanceService;

@RestController
@RequestMapping("/api/auth")
public class AddWalletBalanceController {

	@Autowired
	private AddWalletBalanceService addWalletBalanceService;
	
	@JsonView(View.Base.class)
	@PutMapping("/add-wallet-balance")
	public ResponseEntity<Wallet> updateWalletBalance(@RequestBody Wallet request){
		return new ResponseEntity<Wallet>(addWalletBalanceService.addWalletBalance(request),HttpStatus.CREATED);
	}
	
	
}
