package com.demo.warmedicapp.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class WrongFileException extends RuntimeException {
    private final HttpStatusCode errorCode = HttpStatus.NOT_FOUND;

    public WrongFileException() {
        super("Something is wrong with file");
    }
}
