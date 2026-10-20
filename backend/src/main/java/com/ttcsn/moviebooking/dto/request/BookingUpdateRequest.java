/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.ttcsn.moviebooking.dto.request;

import com.ttcsn.moviebooking.entity.enums.BookingStatus;

import jakarta.validation.constraints.NotNull;
/**
 *
 * @author quanghieu
 */
public record BookingUpdateRequest(
        @NotNull(message = "Trạng thái không được để trống")
        BookingStatus status
) {
}