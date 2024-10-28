package dev.rahul.BMS.service;

import dev.rahul.BMS.model.*;
import dev.rahul.BMS.model.constants.MovieFeature;
import dev.rahul.BMS.model.constants.SeatStatus;
import dev.rahul.BMS.model.constants.SeatType;
import dev.rahul.BMS.model.constants.ShowStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitService {
    @Autowired
    private SeatService seatService;
    @Autowired
    private AuditoriumService auditoriumService;
    @Autowired
    private TheatreService theatreService;
    @Autowired
    private CityService cityService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private ShowService showService;


    public void initialise(){

        //Creating Seats
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Seat seat = new Seat();
            seat.setSeatStatus(SeatStatus.AVAILABLE);
            seat.setSeatNumber("Seat No - " + i);
            seat.setCol(i);
            seat.setRow(i);
            seat.setSeatType(SeatType.GOLD);
            seat = seatService.createSeat(seat);
            seats.add(seat);
        }

        //create Audi
        Auditorium auditorium = new Auditorium();
        auditorium.setCapacity(100);
        auditorium.setName("Audi 1");
        auditorium.setSeats(seats);
        auditorium = auditoriumService.createAuditorium(auditorium);

        //create Theatre
        Theatre theatre = new Theatre();
        theatre.setName("PVR");
        theatre.setAddress("12th street, NY");
        theatre.setAuditoriums(List.of(auditorium));
        theatre = theatreService.createTheatre(theatre);


        //create city
        City city = new City();
        city.setName("Bangalore");
        city.setTheatres(List.of(theatre));
        city = cityService.createCity(city);

        //Create movie
        Movie movie = new Movie();
        movie.setName("movie 1");
        movie.setLanguage("Hindi");
        movie.setMovieFeatures(List.of(MovieFeature.DOLBY, MovieFeature.THREE_D));
        movie = movieService.createMovie(movie);

        //Create a show
        Show show = new Show();
        show.setLanguage("Hindi");
        show.setShowStatus(ShowStatus.YET_TO_START);
        show.setAuditorium(auditorium);
        show.setEndTime(LocalDateTime.now());
        show.setStartTime(LocalDateTime.now());
        //we are not creating showSeats here showSeats are created in the show service automatically
        show = showService.createShow(show);




    }


}
