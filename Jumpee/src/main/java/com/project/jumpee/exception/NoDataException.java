package com.project.jumpee.exception;

@SuppressWarnings("serial")
public class NoDataException extends RuntimeException{
	
	public NoDataException(String message) {
		super(message);
	}
}