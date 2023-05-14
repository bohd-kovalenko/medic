package com.demo.warmedicapp.exceptions.handlers;

import com.demo.warmedicapp.exceptions.UnexistingBlankException;
import com.demo.warmedicapp.exceptions.UnexistingSoldierException;
import com.demo.warmedicapp.exceptions.ValidationException;
import com.demo.warmedicapp.exceptions.WrongFileException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {UnexistingSoldierException.class})
    public ErrorResponse handleUnexistingRoomException(UnexistingSoldierException e) {
        return new ErrorResponseImpl(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(value = {ValidationException.class})
    public ErrorResponse handleValidationException(ValidationException e) {
        return new ErrorResponseImpl(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(value = {WrongFileException.class})
    public ErrorResponse handleValidationException(WrongFileException e) {
        return new ErrorResponseImpl(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(value = {UnexistingBlankException.class})
    public ErrorResponse handleValidationException(UnexistingBlankException e) {
        return new ErrorResponseImpl(e.getErrorCode(), e.getMessage());
    }
}