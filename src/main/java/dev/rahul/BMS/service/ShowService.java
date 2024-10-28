package dev.rahul.BMS.service;

import dev.rahul.BMS.exception.ShowNotFoundException;
import dev.rahul.BMS.model.Seat;
import dev.rahul.BMS.model.Show;
import dev.rahul.BMS.model.ShowSeat;
import dev.rahul.BMS.model.constants.ShowSeatStatus;
import dev.rahul.BMS.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatService showSeatService;

    public Show createShow(Show show) {
        //create the showSeats for the show
        List<ShowSeat> showSeats = new ArrayList<>();
        show = showRepository.save(show);

        List<Seat> seats = show.getAuditorium().getSeats();
        for (Seat seat : seats) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeat(seat);
            showSeat.setPrice(100);
            showSeat.setShow(show);
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            showSeat = showSeatService.createShowSeat(showSeat);
            showSeats.add(showSeat);
        }
        show.setShowSeats(showSeats);
        return show;
    }

    public Show getShowById(int id) {
        return showRepository.findById(id).orElseThrow(
                () -> new ShowNotFoundException("Show with id " + id + " not found")
        );
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public void deleteShowById(int id) {
        showRepository.deleteById(id);
    }
}
/*
     UserService -> UserRepository
     UserService -> CityRepository XXXX

     UserService -> CityService -> CityRepo
 */