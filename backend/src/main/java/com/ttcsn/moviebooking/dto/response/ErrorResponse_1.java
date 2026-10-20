/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.ttcsn.moviebooking.dto.response;

import java.time.OffsetDateTime;
/**
 *
 * @author quanghieu
 */
public record ErrorResponse_1(
        OffsetDateTime timestamp,
        int status,
        String error,
        String message,
        String path
) {
}