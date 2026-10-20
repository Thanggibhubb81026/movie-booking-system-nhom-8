/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ttcsn.moviebooking.repository;

import com.ttcsn.moviebooking.entity.Genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author quanghieu
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    boolean existsByName(String name);
}