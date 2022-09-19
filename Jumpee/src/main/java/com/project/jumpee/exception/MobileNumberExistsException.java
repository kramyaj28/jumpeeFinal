package com.project.jumpee.exception;

@SuppressWarnings("serial")
public class MobileNumberExistsException extends RuntimeException{
	
	public MobileNumberExistsException(String message) {
		super(message);
	}
}