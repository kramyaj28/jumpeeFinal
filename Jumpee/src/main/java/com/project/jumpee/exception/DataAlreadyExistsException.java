package com.project.jumpee.exception;

@SuppressWarnings("serial")
public class DataAlreadyExistsException extends RuntimeException{
	
	public DataAlreadyExistsException(String message) {
		super(message);
	}
}