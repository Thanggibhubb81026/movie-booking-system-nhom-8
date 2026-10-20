/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ttcsn.moviebooking.service;

import com.ttcsn.moviebooking.dto.request.BookingCreateRequest;
import com.ttcsn.moviebooking.dto.request.BookingUpdateRequest;
import com.ttcsn.moviebooking.dto.response.BookingResponse;

import java.util.List;
/**
 *
 * @author quanghieu
 */
public interface BookingService {
    List<BookingResponse> getAllBookings();
    BookingResponse getBookingById(Long id);
    List<BookingResponse> getBookingsByUserId(Long userId);
    List<BookingResponse> getBookingsByShowtimeId(Long showtimeId);
    BookingResponse createBooking(BookingCreateRequest request);
    BookingResponse updateBooking(Long id, BookingUpdateRequest request);
    void deleteBooking(Long id);
}