package com.intertech.cix.exception;


import com.intertech.cix.exception.bad_request.SurveyIdUniqueIdMissMatchException;
import com.intertech.cix.exception.not_found.ResourceNotFoundException;
import com.intertech.cix.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<Error> notFoundExceptionHandler( Exception e) {
        return exceptionHandler(HttpStatus.NOT_FOUND, e);
    }

    @ExceptionHandler(SurveyIdUniqueIdMissMatchException.class)
    private ResponseEntity<Error> badRequestExceptionHandler( Exception e) {
        return exceptionHandler(HttpStatus.BAD_REQUEST, e);
    }


    private ResponseEntity<Error> exceptionHandler(HttpStatus status, Exception e){
        Error error = new Error();
        error.setCode(status.toString());
        error.setError(e.getMessage().toString());
        return ResponseEntity.status(status).body(error);
    }
}
