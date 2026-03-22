package com.example.demo.Employee.Exception;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<Map<String, Object>> handleIllegalState(IllegalStateException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("timestamp", LocalDateTime.now(), "status",
				HttpStatus.BAD_REQUEST.value(), "message", ex.getMessage()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("timestamp", LocalDateTime.now(),
				"status", HttpStatus.INTERNAL_SERVER_ERROR.value(), "error", "Something went wrong"));
	}

}
