package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.ApplicationError;
import com.example.demo.exception.GOGException;

@RestControllerAdvice
public class ExceptionHandlerController  {

	@ExceptionHandler({GOGException.class})
	public ResponseEntity<ApplicationError> handleUserException(GOGException exception){
		
		ResponseEntity<ApplicationError> response=new ResponseEntity<>(exception.getError(),exception.getError().getHttpCode());     
		return response;
	}

}
