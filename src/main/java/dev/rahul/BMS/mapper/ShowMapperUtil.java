package dev.rahul.BMS.mapper;

import dev.rahul.BMS.dto.ShowRequestDto;
import dev.rahul.BMS.dto.ShowResponseDto;
import dev.rahul.BMS.model.Show;
import dev.rahul.BMS.model.constants.ShowStatus;
import dev.rahul.BMS.service.AuditoriumService;
import dev.rahul.BMS.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowMapperUtil {

    @Autowired
    private AuditoriumService auditoriumService;
    @Autowired
    private MovieService movieService;

    public Show dtoToModel(ShowRequestDto showRequestDto) {
        Show show = new Show();
        show.setStartTime(showRequestDto.getStartTime());
        show.setEndTime(showRequestDto.getEndTime());
        show.setShowStatus(ShowStatus.YET_TO_START);
        show.setLanguage(showRequestDto.getLanguage());
        show.setAuditorium(auditoriumService.getAuditoriumById(showRequestDto.getAuditoriumId()));
        show.setMovie(movieService.getMovieById(showRequestDto.getMovieId()));
        return show;
    }

    public ShowResponseDto modelToDto(Show show) {
        ShowResponseDto showResponseDto = new ShowResponseDto();
        showResponseDto.setId(show.getId());
        showResponseDto.setShowStatus(show.getShowStatus().toString());
        showResponseDto.setStartTime(show.getStartTime());
        showResponseDto.setEndTime(show.getEndTime());
        showResponseDto.setLanguage(show.getLanguage());
        showResponseDto.setAuditoriumId(show.getAuditorium().getId());
        showResponseDto.setMovieId(show.getMovie().getId());
        showResponseDto.setAuditoriumName(show.getAuditorium().getName());
        showResponseDto.setMovieName(show.getMovie().getName());
        return showResponseDto;
    }
}