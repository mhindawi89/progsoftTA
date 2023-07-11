package com.progsoft.assignment.exception;

public class FileEmptyException extends RuntimeException {

	private static final long serialVersionUID = -2541872515848701398L;
	
	public FileEmptyException(String message) {
		super(message);
	}

}
