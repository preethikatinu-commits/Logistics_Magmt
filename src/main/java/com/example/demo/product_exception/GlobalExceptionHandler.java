package com.example.demo.product_exception;



	import org.springframework.http.*;
	import org.springframework.web.bind.annotation.*;
	import org.springframework.web.context.request.WebRequest;

	import java.time.LocalDateTime;
	import java.util.*;

	@ControllerAdvice
	public class GlobalExceptionHandler {

	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", ex.getMessage());
	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<?> handleGeneralException(Exception ex, WebRequest request) {
	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "Internal server error");
	        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


