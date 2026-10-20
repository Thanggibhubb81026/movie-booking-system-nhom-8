/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ttcsn.moviebooking.service;

import com.ttcsn.moviebooking.dto.request.GenreRequest;
import com.ttcsn.moviebooking.dto.response.GenreResponse;

import java.util.List;
/**
 *
 * @author quanghieu
 */
public interface GenreService {

    List<GenreResponse> getAllGenres();

    GenreResponse getGenreById(Long genreId);

    GenreResponse createGenre(GenreRequest request);

    GenreResponse updateGenre(Long genreId, GenreRequest request);

    void deleteGenre(Long genreId);
}