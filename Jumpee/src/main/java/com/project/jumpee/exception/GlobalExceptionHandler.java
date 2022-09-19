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
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(PasswordNotMatchException e) {
		return new ResponseEntity<>("Password not match.",HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(UsernameNotExistsException e) {
		return new ResponseEntity<>("Invalid username or password.",HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(WrongPasswordException e) {
		return new ResponseEntity<>("Invalid username or password.",HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(UserNotFoundException e) {
		return new ResponseEntity<>("User not found.",HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(LoginFirstException e) {
		return new ResponseEntity<>("You must login first.",HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(CurrentPasswordMatchedException e) {
		return new ResponseEntity<>("Current password is not the same with your old password.",HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(ConfirmPasswordMatchedException e) {
		return new ResponseEntity<>("Current password is the same with your new password.",HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(LogoutException e) {
		return new ResponseEntity<>("You must logout first.\nYou may change your password in the \"My Account\" page instead.",HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(NoDataException e) {
		return new ResponseEntity<>("No data available.",HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(DataAlreadyExistsException e) {
		return new ResponseEntity<>("Data already exists. Please edit your details.",HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(InsufficientBalanceException e) {
		return new ResponseEntity<>("Insufficient balance. Please deposit.",HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(CartIsEmptyException e) {
		return new ResponseEntity<>("Cart is empty.",HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(NoOrderHistoryException e) {
		return new ResponseEntity<>("No order history to show.",HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(CheckedOutException e) {
		return new ResponseEntity<>("Error. You already purchased this item.",HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAuthenticationException(AlreadyLoginException e) {
		return new ResponseEntity<>("You're logged in already.",HttpStatus.OK);
	}
	
}
