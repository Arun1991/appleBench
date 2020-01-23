package com.Apple.Assignment.Exceptions;

public class StudentServiceException extends RuntimeException {
	private static final long serialVersionUID = 123456789L;

	public StudentServiceException(String errorMsg) {
		super(errorMsg);

	}
	

}
