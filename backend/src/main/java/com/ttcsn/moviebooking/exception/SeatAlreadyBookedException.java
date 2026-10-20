/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttcsn.moviebooking.exception;

/**
 *
 * @author quanghieu
 */
public class SeatAlreadyBookedException extends RuntimeException {

    public SeatAlreadyBookedException(Long showtimeSeatId) {
        super("Ghế đã được đặt hoặc đang được giữ, showtimeSeatId = " + showtimeSeatId);
    }

    public SeatAlreadyBookedException(String message) {
        super(message);
    }
}