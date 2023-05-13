package com.demo.warmedicapp.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class ValidationException extends RuntimeException {
    private final HttpStatusCode errorCode = HttpStatus.BAD_REQUEST;

    public ValidationException() {
        super("Something is wrong with object");
    }
}
