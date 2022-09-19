package com.project.jumpee.exception;

@SuppressWarnings("serial")
public class AlreadyLoginException extends RuntimeException{
	
	public AlreadyLoginException(String message) {
		super(message);
	}
}