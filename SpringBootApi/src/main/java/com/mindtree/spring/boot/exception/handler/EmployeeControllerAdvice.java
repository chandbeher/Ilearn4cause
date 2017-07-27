package com.mindtree.spring.boot.exception.handler;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeControllerAdvice {

	@ResponseBody
	@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE)
	@ExceptionHandler(value = Exception.class)
	public VndErrors globalExceptionHandler(Exception ex) {
		return new VndErrors("error", ex.getMessage());
	}
}
