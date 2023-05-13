package com.demo.warmedicapp.exceptions.handlers;

import com.demo.warmedicapp.exceptions.UnexistingSoldierException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {UnexistingSoldierException.class})
    public ErrorResponse handleUnexistingRoomException(UnexistingSoldierException e) {
        return new ErrorResponseImpl(e.getErrorCode(), e.getMessage());
    }
}