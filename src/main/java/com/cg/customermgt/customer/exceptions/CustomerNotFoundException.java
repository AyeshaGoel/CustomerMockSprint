package com.cg.customermgt.customer.exceptions;

public class CustomerNotFoundException extends RuntimeException{
	
	public CustomerNotFoundException(String msg) {
		super(msg);
	}

}
