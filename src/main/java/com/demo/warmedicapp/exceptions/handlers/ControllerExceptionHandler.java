package com.demo.warmedicapp.exceptions.handlers;

import com.demo.warmedicapp.exceptions.UnexistingSoldierException;
import com.demo.warmedicapp.exceptions.ValidationException;
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
}