/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.ttcsn.moviebooking.dto.response;

import com.ttcsn.moviebooking.entity.enums.UserRole;

/**
 *
 * @author quanghieu
 */
public record UserResponse(
        Long userId,
        String fullName,
        String email,
        String phoneNumber,
        UserRole role
) {
}