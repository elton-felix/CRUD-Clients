package com.personalproject.crudclients.services.exeptions;

public class DatabaseException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DatabaseException(String message) {
		super(message);
	}
	
	
}
