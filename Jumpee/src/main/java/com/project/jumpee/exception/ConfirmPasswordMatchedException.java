package com.project.jumpee.exception;

@SuppressWarnings("serial")
public class ConfirmPasswordMatchedException extends RuntimeException {

	public ConfirmPasswordMatchedException(String message) {
		super(message);
	}
}
