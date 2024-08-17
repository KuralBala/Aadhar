package com.qspider.springbootproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.qspider.springbootproject.util.ResponseStructure;
                  
@RestControllerAdvice										
public class ExceptionHandler extends ResponseEntityExceptionHandler{
						//bcz we use reponseentitytoretuntheobjects
	@org.springframework.web.bind.annotation.ExceptionHandler							//pass usernotfoundexception method
	 public ResponseEntity<ResponseStructure<String>> handleUserNotFoundException(UserNotFound exception){
		 ResponseStructure<String> structure =new ResponseStructure<String>();
		 structure.setData(exception.getMessage());
		 structure.setMessage("could not find user with provided id");
		 structure.setStatus(HttpStatus.NOT_FOUND.value()); 
	  return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	 }
	
	//aadhar
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleAadharNotFoundException(AadharNotFoundException exception){
		 ResponseStructure<String> structure =new ResponseStructure<String>();
		 structure.setData(exception.getMessage());
		 structure.setMessage("could not find Aadhar with provided id");
		 structure.setStatus(HttpStatus.NOT_FOUND.value()); 
	  return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	 }
}
