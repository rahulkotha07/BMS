package dev.rahul.BMS.controller;


import dev.rahul.BMS.dto.MovieResponseDto;
import dev.rahul.BMS.mapper.MovieMapperUtil;
import dev.rahul.BMS.model.Movie;
import dev.rahul.BMS.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/movie")
    public ResponseEntity<MovieResponseDto> createMovie(@RequestBody Movie movie){
        movie = movieService.createMovie(movie);
        return ResponseEntity.ok(MovieMapperUtil.modeToDto(movie));
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieResponseDto> getMovieById(@PathVariable("id") int id){
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(MovieMapperUtil.modeToDto(movie));
    }
}
