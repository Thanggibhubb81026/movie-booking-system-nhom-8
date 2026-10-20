/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ttcsn.moviebooking.service;

import com.ttcsn.moviebooking.dto.request.SeatRequest;
import com.ttcsn.moviebooking.dto.response.SeatResponse;

import java.util.List;
/**
 *
 * @author quanghieu
 */
public interface SeatService {

    List<SeatResponse> getSeatsByRoomId(Long roomId);

    SeatResponse getSeatById(Long seatId);

    SeatResponse createSeat(SeatRequest request);

    SeatResponse updateSeat(Long seatId, SeatRequest request);

    void deleteSeat(Long seatId);
}