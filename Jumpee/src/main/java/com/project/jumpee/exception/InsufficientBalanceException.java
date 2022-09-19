package com.project.jumpee.exception;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends RuntimeException{
	
	public InsufficientBalanceException(String message) {
		super(message);
	}
}