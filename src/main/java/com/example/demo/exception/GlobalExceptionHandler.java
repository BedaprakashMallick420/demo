package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.apiresponse.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RequiredFieldException.class)
    public static ResponseEntity<?> handleRequiredFieldException(RequiredFieldException ex) {
        return new ResponseEntity<>(ApiResponse.errorResponse(ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RequiredFieldException.class)
    public static ResponseEntity<?> handleDataNotFoundException(DuplicateException ex) {
        return new ResponseEntity<>(ApiResponse.errorResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateException.class)
    public static ResponseEntity<?> handleDuplicateException(DuplicateException ex) {
        return new ResponseEntity<>(ApiResponse.errorResponse(ex.getMessage()), HttpStatus.CONFLICT);
    }
}