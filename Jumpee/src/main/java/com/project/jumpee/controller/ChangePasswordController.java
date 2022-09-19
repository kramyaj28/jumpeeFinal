package com.project.jumpee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.jumpee.dto.ChangeResetPasswordDto;
import com.project.jumpee.service.ChangePasswordService;

@RestController
@RequestMapping("/api/auth")
public class ChangePasswordController {

	@Autowired
	private ChangePasswordService changePasswordService;

	@PutMapping("/change-password")
	public String resetPassword(@Valid @RequestBody ChangeResetPasswordDto request) {
		return changePasswordService.changePassword(request);
	}
}