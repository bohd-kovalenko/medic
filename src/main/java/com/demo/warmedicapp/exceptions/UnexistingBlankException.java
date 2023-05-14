package com.demo.warmedicapp.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class UnexistingBlankException extends RuntimeException {
    private final HttpStatusCode errorCode = HttpStatus.NOT_FOUND;

    public UnexistingBlankException(Integer id) {
        super("Unexisting blank with id " + id);
    }
}