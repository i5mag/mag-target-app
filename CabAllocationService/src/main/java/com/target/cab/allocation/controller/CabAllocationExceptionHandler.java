package com.target.cab.allocation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.target.cab.allocation.model.CustomException;
import com.target.cab.allocation.model.StatusVO;

@ControllerAdvice
public class CabAllocationExceptionHandler {
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<StatusVO> handleCustomException(CustomException ex)
	{
		StatusVO responseStatus = new StatusVO("Failure", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), ex.getErrorMessage());
		return new ResponseEntity<StatusVO>(responseStatus, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<StatusVO> handleException(Exception ex)
	{
		StatusVO responseStatus = new StatusVO("Failure", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), ex.getMessage());
		return new ResponseEntity<StatusVO>(responseStatus, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
