package com.project.jumpee.exception;

@SuppressWarnings("serial")
public class NoOrderHistoryException extends RuntimeException {

	public NoOrderHistoryException(String message) {
		super(message);
	}
}
