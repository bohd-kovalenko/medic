package com.demo.warmedicapp.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class UnexistingSoldierException extends RuntimeException {
    private final HttpStatusCode errorCode = HttpStatus.NOT_FOUND;

    public UnexistingSoldierException(Integer id) {
        super("Unexisting soldier with id " + id);
    }
}
