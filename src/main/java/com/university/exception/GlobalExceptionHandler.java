package com.university.exception;

import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

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

                // ex.printStackTrace(); // chỉ log server

                ErrorMessage error = new ErrorMessage(
                                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                new Date(),
                                "Đã xảy ra lỗi hệ thống",
                                request.getDescription(false));

                return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ErrorMessage> handleNotFound(ResourceNotFoundException ex, WebRequest request) {

                ErrorMessage error = new ErrorMessage(
                                HttpStatus.NOT_FOUND.value(),
                                new Date(),
                                ex.getMessage(),
                                request.getDescription(false));

                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<String> handleValidationErrors(MethodArgumentNotValidException ex) {
                String error = ex.getBindingResult().getFieldErrors().stream()
                                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                                .collect(Collectors.joining(", "));
                return ResponseEntity
                                .badRequest()
                                .body(error);
        }

        @ExceptionHandler(SimpleMessageException.class)
        public ResponseEntity<?> handleSimpleMessage(SimpleMessageException ex) {
                return ResponseEntity
                                .status(HttpStatus.UNAUTHORIZED)
                                .body(Map.of("message", ex.getMessage()));
        }

        @ExceptionHandler(NoResourceFoundException.class)
        public ResponseEntity<ErrorMessage> handleNoResourceFound(NoResourceFoundException ex, WebRequest request) {
                ErrorMessage error = new ErrorMessage(
                                HttpStatus.NOT_FOUND.value(),
                                new Date(),
                                "Không tìm thấy tài nguyên tĩnh: " + ex.getMessage(),
                                request.getDescription(false));
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        // Có thể thêm các handler khác như MethodArgumentNotValidException, etc.
}