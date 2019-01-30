package com.example.demo.exception;

public class GOGException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ApplicationError error;
	
	public GOGException() {		
	}
	
	public GOGException(String message){
		super(message);
	}

	public GOGException(ApplicationError error) {
		super();
		this.error = error;
	}

	public ApplicationError getError() {
		return error;
	}

	public void setError(ApplicationError error) {
		this.error = error;
	}
	
	
	


}
