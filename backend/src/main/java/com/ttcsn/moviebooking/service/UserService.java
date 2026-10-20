/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ttcsn.moviebooking.service;

import com.ttcsn.moviebooking.dto.request.UserCreateRequest;
import com.ttcsn.moviebooking.dto.request.UserUpdateRequest;
import com.ttcsn.moviebooking.dto.response.UserResponse;

import java.util.List;
/**
 *
 * @author quanghieu
 */
public interface UserService {
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    UserResponse createUser(UserCreateRequest request);
    UserResponse updateUser(Long id, UserUpdateRequest request);
    void deleteUser(Long id);
}