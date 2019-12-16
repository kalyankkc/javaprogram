package com.mindtree.department.controller.handler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.department.controller.DepartmentController;
import com.mindtree.department.exception.serviceexception.NoSuchDepartmentException;

@RestControllerAdvice(assignableTypes = {DepartmentController.class})
public class ControllerExceptionHandler {
	
	@ExceptionHandler(NoSuchDepartmentException.class)
	public ResponseEntity<Map<String, Object>> handleDeartmentNotException(NoSuchDepartmentException e) {
		Map<String, Object> error= new HashMap<String, Object>();
		error.put("timeslamp", new Date());
		error.put("httpStatus", HttpStatus.BAD_REQUEST.value());
		error.put("massege", e.getMessage());
		error.put("Body", null);
		error.put("error", true);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
