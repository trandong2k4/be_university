package com.university.exception;

import java.util.Date;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        ErrorMessage error = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(System.currentTimeMillis()),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGeneralException(Exception ex, WebRequest request) {
        ex.printStackTrace(); // 👈 thêm dòng này
        ErrorMessage error = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(System.currentTimeMillis()),
                "Lỗi hệ thống",
                request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
