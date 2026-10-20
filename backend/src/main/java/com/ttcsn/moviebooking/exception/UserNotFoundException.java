/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttcsn.moviebooking.exception;

/**
 *
 * @author quanghieu
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long userId) {
        super("Không tìm thấy người dùng với userId = " + userId);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}