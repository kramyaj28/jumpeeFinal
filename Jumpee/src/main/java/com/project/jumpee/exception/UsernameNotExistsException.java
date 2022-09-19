package com.project.jumpee.exception;

@SuppressWarnings("serial")
public class UsernameNotExistsException extends RuntimeException{
	
	public UsernameNotExistsException(String message) {
		super(message);
	}
}