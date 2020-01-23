package com.Apple.Assignment.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(StudentServiceException.class)
	public ResponseEntity<ErrorMessage> handleStudentServiceException(StudentServiceException ex) {
		ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), ex.getMessage());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
