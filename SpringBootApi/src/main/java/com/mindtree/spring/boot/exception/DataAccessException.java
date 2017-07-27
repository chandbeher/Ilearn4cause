package com.mindtree.spring.boot.exception;

public class DataAccessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataAccessException(String flow) {
		super("Error while performing DB Operation. " + flow );
	}

}
