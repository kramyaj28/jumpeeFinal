package com.project.jumpee.exception;

@SuppressWarnings("serial")
public class WrongPasswordException extends RuntimeException{
	
	public WrongPasswordException(String message) {
		super(message);
	}
}