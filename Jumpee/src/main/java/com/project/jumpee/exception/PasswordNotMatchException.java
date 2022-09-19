package com.project.jumpee.exception;

@SuppressWarnings("serial")
public class PasswordNotMatchException extends RuntimeException {

	public PasswordNotMatchException(String message) {
		super(message);
	}
}
