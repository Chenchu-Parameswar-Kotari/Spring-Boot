package com.springboot.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.springboot.demo.custom.beans.CustomErrorMessage;

@ControllerAdvice
public class GobalExceptionHandling {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomErrorMessage> handleDataNotFoundException(ResourceNotFoundException r,WebRequest webRequest)
	{
		CustomErrorMessage cme=new CustomErrorMessage(r.getLocalizedMessage()+"  "+webRequest.toString(),HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<>(cme,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomErrorMessage> handleException(Exception e,WebRequest webRequest)
	{
		CustomErrorMessage cme=new CustomErrorMessage(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return new ResponseEntity<>(cme,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<CustomErrorMessage> handleNullPointerException(Exception e,WebRequest webRequest)
	{
		CustomErrorMessage cme=new CustomErrorMessage(e.getLocalizedMessage(),HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<>(cme,HttpStatus.NOT_FOUND);
	}


}
