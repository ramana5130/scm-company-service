package com.ram.company.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ram.company.exception.CompanyNotFoundException;
import com.ram.company.payload.response.ErrorMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCompanyNotFoundException(CompanyNotFoundException cnfe) {

		return ResponseEntity.internalServerError().body(new ErrorMessage(new Date().toString(), cnfe.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name()));

	}

}
