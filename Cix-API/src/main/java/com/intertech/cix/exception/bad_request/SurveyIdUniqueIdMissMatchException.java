package com.intertech.cix.exception.bad_request;

public class SurveyIdUniqueIdMissMatchException extends RuntimeException {
    private String message;

    public SurveyIdUniqueIdMissMatchException(String message) {
        super(message);
        this.message = message;
    }
}