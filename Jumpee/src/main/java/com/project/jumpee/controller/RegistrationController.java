package com.project.jumpee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.jumpee.dto.RegisterDto;
import com.project.jumpee.exception.View;
import com.project.jumpee.model.User;
import com.project.jumpee.service.RegistrationService;

@RestController
@RequestMapping("/api/auth")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;
    
    public RegistrationController(RegistrationService registrationService) {
		super();
		this.registrationService = registrationService;
	}

    @JsonView(View.Base.class)
	@PostMapping("/signup")
    public ResponseEntity<User> registerUser(@Valid @RequestBody RegisterDto request){
    	return new ResponseEntity<User>(registrationService.registerUser(request), HttpStatus.CREATED);
    }
    
    
}