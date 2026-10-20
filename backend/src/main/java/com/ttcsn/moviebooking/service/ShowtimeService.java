/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ttcsn.moviebooking.service;

import com.ttcsn.moviebooking.dto.request.ShowtimeRequest;
import com.ttcsn.moviebooking.dto.response.ShowtimeResponse;

import java.util.List;
/**
 *
 * @author quanghieu
 */
public interface ShowtimeService {

    List<ShowtimeResponse> getAllShowtimes();

    List<ShowtimeResponse> getShowtimesByMovieId(Long movieId);

    ShowtimeResponse getShowtimeById(Long showtimeId);

    ShowtimeResponse createShowtime(ShowtimeRequest request);

    ShowtimeResponse updateShowtime(Long showtimeId, ShowtimeRequest request);

    void deleteShowtime(Long showtimeId);
}