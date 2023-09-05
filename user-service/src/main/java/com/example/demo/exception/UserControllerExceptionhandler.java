package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.ui.ErrorResponseModel;

@ControllerAdvice
public class UserControllerExceptionhandler {
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleUserNotFoundException(UserNotFoundException e)
	{
		ErrorResponseModel model=new ErrorResponseModel();
		model.setErrorCode(HttpStatus.NOT_FOUND.value());
		model.setErrorReportingTime(System.currentTimeMillis());
		model.setMessage(e.getErrorMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);
	}
}
