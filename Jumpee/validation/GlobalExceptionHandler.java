package com.project.jumpee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(EmailExistsException e) {
		return new ResponseEntity<>("Email already exists.",HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(MobileNumberExistsException e) {
		return new ResponseEntity<>("Mobile number already exists.",HttpStatus.OK);
	}
	
	
}
