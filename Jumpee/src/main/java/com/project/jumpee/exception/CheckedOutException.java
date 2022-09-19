package com.project.jumpee.exception;

@SuppressWarnings("serial")
public class CheckedOutException extends RuntimeException{
	
	public CheckedOutException(String message) {
		super(message);
	}
}