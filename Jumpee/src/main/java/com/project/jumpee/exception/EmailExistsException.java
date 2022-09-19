package com.project.jumpee.exception;

@SuppressWarnings("serial")
public class EmailExistsException extends RuntimeException{
	
	public EmailExistsException(String message) {
		super(message);
	}
}