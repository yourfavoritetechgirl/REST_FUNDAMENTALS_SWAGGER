package com.simplilearn.config;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
@RestControllerAdvice
public class ExceptionHandlerConfig {
	
	@ExceptionHandler(value=ArithmeticException.class)
	public String arithmeticExceptionHandled() {
		return "Internal error occured Globally";
	}

}
