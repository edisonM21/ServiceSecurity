package com.cinema.globant.ServiceSecurity.service;

import com.cinema.globant.ServiceSecurity.dto.Movies;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ServiceMovies {

    private final RestTemplate restTemplate;


    @Value("https://api.themoviedb.org/3/movie")
    private String basePath;

    private String Key="?api_key=99632828d29e9522db0e54fd17194222";

    //return (List<Movies>) ResponseEntity.noContent().build();

    public List<Movies> getMoviesNow_Playing(){
        try {
            Movies response = restTemplate.getForObject(basePath+"/now_playing"+Key,Movies.class);
            return Arrays.asList(response);
        }catch (Exception e) {
            System.out.println("Error: No se encontraron los nuevos estrenos"+e.getMessage());
        }
        return null;
    }
}
