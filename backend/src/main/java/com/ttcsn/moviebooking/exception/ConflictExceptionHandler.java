/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttcsn.moviebooking.exception;

import com.ttcsn.moviebooking.dto.response.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 *
 * @author quanghieu
 */
@RestControllerAdvice
public class ConflictExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolation(
            DataIntegrityViolationException ex, HttpServletRequest request) {
        return ErrorResponseFactory.build(
                HttpStatus.CONFLICT, "Dữ liệu vi phạm ràng buộc, vui lòng kiểm tra lại", request);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEmailAlreadyExists(
            EmailAlreadyExistsException ex, HttpServletRequest request) {
        return ErrorResponseFactory.build(HttpStatus.CONFLICT, ex.getMessage(), request);
    }

    @ExceptionHandler(SeatAlreadyBookedException.class)
    public ResponseEntity<ErrorResponse> handleSeatAlreadyBooked(
            SeatAlreadyBookedException ex, HttpServletRequest request) {
        return ErrorResponseFactory.build(HttpStatus.CONFLICT, ex.getMessage(), request);
    }
}