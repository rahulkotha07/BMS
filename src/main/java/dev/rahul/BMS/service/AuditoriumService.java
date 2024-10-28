package dev.rahul.BMS.service;

import dev.rahul.BMS.exception.AuditoriumNotFoundException;
import dev.rahul.BMS.model.Auditorium;
import dev.rahul.BMS.model.Seat;
import dev.rahul.BMS.model.constants.SeatStatus;
import dev.rahul.BMS.model.constants.SeatType;
import dev.rahul.BMS.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuditoriumService {

    @Autowired
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    private SeatService seatService;

    public Auditorium createAuditorium(Auditorium auditorium) {
        List<Seat> seats = new ArrayList<>();
        for(int i=0; i<auditorium.getCapacity(); i++){
            Seat seat = new Seat();
            seat.setSeatStatus(SeatStatus.AVAILABLE);
            seat.setSeatNumber("Seat No - " + i);
            seat.setCol(i);
            seat.setRow(i);
            seat.setSeatType(SeatType.GOLD);
            seat = seatService.createSeat(seat);
            seats.add(seat);
        }
        auditorium.setSeats(seats);
        return auditoriumRepository.save(auditorium);
    }

    public Auditorium getAuditoriumById(int id) {
        return auditoriumRepository.findById(id).orElseThrow(
                () -> new AuditoriumNotFoundException("Auditorium with id " + id + " not found")
        );
    }

    public List<Auditorium> getAllAuditoriums() {
        return auditoriumRepository.findAll();
    }

    public List<Auditorium> getAllAuditoriumsByTheatreId(int id) {
        return auditoriumRepository.findAllByTheatre_Id(id);
    }

    public void deleteAuditoriumById(int id) {
        auditoriumRepository.deleteById(id);
    }
}