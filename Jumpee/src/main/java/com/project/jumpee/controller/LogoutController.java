package com.project.jumpee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.jumpee.model.User;
import com.project.jumpee.service.LogoutService;

@RestController
@RequestMapping("/api/auth")
public class LogoutController {
    
    @Autowired
	private LogoutService logoutService;
    
	@PutMapping("/logout")
    public ResponseEntity<String> logoutUser(User user){
        return new ResponseEntity<>(logoutService.logoutUser(user), HttpStatus.OK);
    }
    
}