package com.masai.exception;

public class AddressNotFound extends RuntimeException{

	public AddressNotFound() {
		
	}
	
	public AddressNotFound(String message) {
		super(message);
	}
}
