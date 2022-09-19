package com.project.jumpee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.jumpee.dto.LoginDto;
import com.project.jumpee.exception.View;
import com.project.jumpee.model.User;
import com.project.jumpee.service.LoginService;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    
    @Autowired
	private LoginService loginService;
    
    @JsonView(View.Base.class)
	@PostMapping("/signin")
    public ResponseEntity<User> authenticateUser(@RequestBody LoginDto request){
        return new ResponseEntity<>(loginService.loginUser(request), HttpStatus.OK);
    }
    
}