package com.project.jumpee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.jumpee.exception.View;
import com.project.jumpee.model.Wallet;
import com.project.jumpee.service.WalletService;

@RestController
@RequestMapping("/api/auth")
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@JsonView(View.Base.class)
	@PutMapping("/add-wallet-balance")
	public ResponseEntity<Wallet> updateWalletBalance(@RequestBody Wallet request){
		return new ResponseEntity<Wallet>(walletService.addWalletBalance(request),HttpStatus.CREATED);
	}
	
	
	@JsonView(View.Base.class)
	@GetMapping("/view-balance")
	public ResponseEntity<Wallet> viewBalance(Wallet request) {
		return new ResponseEntity<Wallet>(walletService.viewWalletBalance(request),HttpStatus.OK);
	}
	
}
