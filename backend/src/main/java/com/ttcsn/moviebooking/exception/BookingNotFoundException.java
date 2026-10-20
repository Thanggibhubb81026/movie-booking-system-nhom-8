/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttcsn.moviebooking.exception;

/**
 *
 * @author quanghieu
 */
public class BookingNotFoundException extends RuntimeException {

    public BookingNotFoundException(Long bookingId) {
        super("Không tìm thấy đơn đặt vé với bookingId = " + bookingId);
    }

    public BookingNotFoundException(String message) {
        super(message);
    }
}