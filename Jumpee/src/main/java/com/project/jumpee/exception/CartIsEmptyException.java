package com.project.jumpee.exception;

@SuppressWarnings("serial")
public class CartIsEmptyException extends RuntimeException {

	public CartIsEmptyException(String message) {
		super(message);
	}
}
