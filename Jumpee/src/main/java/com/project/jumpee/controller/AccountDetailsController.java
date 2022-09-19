package com.project.jumpee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.jumpee.exception.View;
import com.project.jumpee.model.User;
import com.project.jumpee.service.AccountDetailsService;

@RestController
@RequestMapping("/api/auth")
public class AccountDetailsController {

    @Autowired
	private AccountDetailsService accountDetailsService;

	@GetMapping("/account-details")
	@JsonView(View.Base.class)
    public ResponseEntity<User> getUserDetails(){
        return new ResponseEntity<User>(accountDetailsService.getUserDetails(), HttpStatus.OK);
    }
}