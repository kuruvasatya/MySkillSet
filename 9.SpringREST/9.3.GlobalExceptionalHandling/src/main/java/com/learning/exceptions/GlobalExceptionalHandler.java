package com.learning.exceptions;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorResponse> handleGenericException(DataAccessException ex) {
        ErrorResponse errorResponse = new ErrorResponse("Data Access Execption", HttpStatus.INTERNAL_SERVER_ERROR.value());
        System.out.println(ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleBeanValidationError(MethodArgumentNotValidException ex) {
        ArrayList<String> errors = new ArrayList<String>();
        ex.getBindingResult().getFieldErrors().stream().forEach(error -> errors.add(error.getDefaultMessage()));
        ErrorResponse errorResponse = new ErrorResponse("Invalid Input", HttpStatus.BAD_REQUEST.value(), errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
