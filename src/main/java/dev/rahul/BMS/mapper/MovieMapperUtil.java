package dev.rahul.BMS.mapper;

import dev.rahul.BMS.dto.MovieResponseDto;
import dev.rahul.BMS.model.Movie;

public class MovieMapperUtil {

    public static MovieResponseDto modeToDto(Movie movie){
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(movie.getId());
        movieResponseDto.setName(movie.getName());
        movieResponseDto.setLanguage(movie.getLanguage());
        return movieResponseDto;
    }
}
