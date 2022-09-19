package com.project.jumpee.exception;

@SuppressWarnings("serial")
public class CurrentPasswordMatchedException extends RuntimeException {

	public CurrentPasswordMatchedException(String message) {
		super(message);
	}
}
