package com.infy.exception;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.utility.ErrorInfo;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	private static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);

	@Autowired
	private Environment environment;

	@ExceptionHandler(TrainingException.class)
	public ResponseEntity<ErrorInfo> TrainingExceptionHandler(TrainingException exception) {
		LOGGER.error(exception.getMessage(), exception);
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMessage(environment.getProperty(exception.getMessage()));
		return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
	}



}
