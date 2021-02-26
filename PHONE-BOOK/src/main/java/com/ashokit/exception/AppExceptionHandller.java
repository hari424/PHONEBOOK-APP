package com.ashokit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandller {
	@ExceptionHandler(value = NoDataFoundException.class)
public ResponseEntity<String> handleNoDataFoundException(NoDataFoundException ndfe){
	String exMsg = ndfe.getMessage();
	
	return new ResponseEntity<String>(exMsg,HttpStatus.BAD_REQUEST);
	
}
}
