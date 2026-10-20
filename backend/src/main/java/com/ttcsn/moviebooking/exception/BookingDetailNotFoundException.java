/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttcsn.moviebooking.exception;

/**
 *
 * @author quanghieu
 */
public class BookingDetailNotFoundException extends RuntimeException {

    public BookingDetailNotFoundException(Long bookingDetailId) {
        super("Không tìm thấy chi tiết đặt vé với bookingDetailId = " + bookingDetailId);
    }

    public BookingDetailNotFoundException(String message) {
        super(message);
    }
}