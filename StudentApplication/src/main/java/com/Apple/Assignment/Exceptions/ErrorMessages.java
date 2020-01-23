package com.Apple.Assignment.Exceptions;

public enum ErrorMessages {
	
	RECORD_ALREADY_EXISTS("Student already exists with given id"), 
	NO_RECORD_FOUND("Student not found with the given id! hence update not possible"),
	NOT_FOUND_WITH_GIVEN_AGE("Student not found with the given age"),
	NOT_FOUND_WITH_GIVEN_GRADE("Student not found with the given grade"),
	NOT_FOUND_WITH_GIVEN_ID("Student not found with the given id"),
	NOT_FOUND_WITH_GIVEN_AGE_AND_GRADE("Student not found with the given age and grade"),
	NOT_FOUND_WITH_GIVEN_ID_DELETE("Student not found with the given id! hence Delete is  not possible");
	
	private String errorMessage;

	private ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
