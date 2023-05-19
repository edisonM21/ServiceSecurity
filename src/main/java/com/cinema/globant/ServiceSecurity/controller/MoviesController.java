package com.cinema.globant.ServiceSecurity.controller;

import com.cinema.globant.ServiceSecurity.dto.Movies;
import com.cinema.globant.ServiceSecurity.service.ServiceMovies;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/security")
@RequiredArgsConstructor
public class MoviesController {

    private final ServiceMovies serviceMovies;

    @GetMapping("/now_playing")
    public ResponseEntity<List<Movies>> getNow_playing(){
        return new ResponseEntity(serviceMovies.getMoviesNow_Playing(), HttpStatus.OK);
    }
}
