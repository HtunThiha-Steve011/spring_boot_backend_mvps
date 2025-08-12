package com.steve.bug_bounty_system.exception;

import com.steve.bug_bounty_system.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUsernameAlreadyExists() {
        ErrorResponse errorResponse = new ErrorResponse(409, "Username already exists.");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }
}
