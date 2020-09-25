package com.example.restcontrolleradvice.exception;

import com.example.restcontrolleradvice.dto.BuzzException;
import com.example.restcontrolleradvice.dto.FizzBuzzException;
import com.example.restcontrolleradvice.dto.FizzException;
import com.example.restcontrolleradvice.dto.GlobalError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FizzException.class)
    public ResponseEntity<GlobalError> fizzException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return new ResponseEntity<>(new GlobalError(bodyOfResponse, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BuzzException.class)
    public ResponseEntity<GlobalError> buzzException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return new ResponseEntity<>(new GlobalError(bodyOfResponse, HttpStatus.BAD_REQUEST.getReasonPhrase()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FizzBuzzException.class)
    public ResponseEntity<GlobalError> fizzBuzzException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return new ResponseEntity<>(new GlobalError(bodyOfResponse, HttpStatus.INSUFFICIENT_STORAGE.getReasonPhrase()), HttpStatus.INSUFFICIENT_STORAGE);
    }
}
