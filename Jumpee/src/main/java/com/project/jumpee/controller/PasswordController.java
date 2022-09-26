package com.project.jumpee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.jumpee.dto.ChangeResetPasswordDto;
import com.project.jumpee.exception.View;
import com.project.jumpee.model.User;
import com.project.jumpee.service.PasswordService;

@RestController
@RequestMapping("/api/auth")
public class PasswordController {

	@Autowired
	private PasswordService passwordService;

	@PutMapping("/change-password")
	public String changePassword(@Valid @RequestBody ChangeResetPasswordDto request) {
		return passwordService.changePassword(request);
	}
	
	@JsonView(View.Base.class)
	@PutMapping("/reset-password")
	public ResponseEntity<User> resetPassword(@Valid @RequestBody ChangeResetPasswordDto request) {
		return new ResponseEntity<User>(passwordService.resetPassword(request), HttpStatus.OK);
	}
	
}