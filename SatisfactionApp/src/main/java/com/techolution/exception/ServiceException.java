package com.techolution.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException(String messageValue){
		super(messageValue);
	}
}
