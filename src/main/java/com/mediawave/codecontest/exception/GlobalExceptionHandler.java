package com.mediawave.codecontest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.concurrent.ExecutionException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExecutionException.class)
    public ResponseEntity<String> handleExecutionException(ExecutionException e) {
        // Log the exception
        e.printStackTrace();
        return new ResponseEntity<>("A server error occurred while processing the request.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InterruptedException.class)
    public ResponseEntity<String> handleInterruptedException(InterruptedException e) {
        // Log the exception
        e.printStackTrace();
        return new ResponseEntity<>("The request was interrupted.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        // Log the exception
        e.printStackTrace();
        return new ResponseEntity<>("An unexpected error occurred from client side.", HttpStatus.BAD_REQUEST);
    }
}
