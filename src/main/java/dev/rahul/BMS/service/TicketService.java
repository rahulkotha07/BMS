package dev.rahul.BMS.service;

import dev.rahul.BMS.dto.TicketDto;
import dev.rahul.BMS.exception.SeatNotAvailableException;
import dev.rahul.BMS.exception.TicketNotFoundException;
import dev.rahul.BMS.model.*;
import dev.rahul.BMS.model.constants.PaymentStatus;
import dev.rahul.BMS.model.constants.SeatType;
import dev.rahul.BMS.model.constants.ShowSeatStatus;
import dev.rahul.BMS.model.constants.TicketStatus;
import dev.rahul.BMS.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ShowSeatService showSeatService;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket createTicket(TicketDto ticketDto){
        User user = userService.getUserById(ticketDto.getUserId());
        List<ShowSeat> showSeats = new ArrayList<>();
        for (Integer i : ticketDto.getShowSeatIds()){
            showSeats.add(showSeatService.getShowSeatById(i));
        }

        for (ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SeatNotAvailableException("Selected Seats are not available");
            }
        }

        for (ShowSeat showSeat : showSeats){
            if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
                showSeatService.updtateShowSeat(showSeat);
            }
        }
        return generateTicket(user, showSeats);
    }
    private Ticket generateTicket(User user, List<ShowSeat> showSeats){
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setBookingTime(LocalDateTime.now());
        ticket.setShow(showSeats.get(0).getShow());
        int cost = 0;
        for (int i = 0; i < showSeats.size(); i++) {
            ShowSeat showSeat = showSeats.get(i);
            if(showSeat.getSeat().getSeatType().equals(SeatType.GOLD)){
                cost += 150;
            }
            else if(showSeat.getSeat().getSeatType().equals(SeatType.PLATINUM)){
                cost += 200;
            }
            else if(showSeat.getSeat().getSeatType().equals(SeatType.SILVER)) {
                cost += 100;
            }
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
            showSeatService.updtateShowSeat(showSeat);
        }
        ticket.setShowSeats(showSeats);
        ticket.setCost(cost);
        return ticketRepository.save(ticket);
    }

    private Ticket bookTicket(Ticket ticket, Payment payment){
        if(!payment.getPaymentStatus().equals(PaymentStatus.SUCCESSFUL)){
            ticket.setTicketStatus(TicketStatus.CANCELLED);
            List<ShowSeat> showSeats = ticket.getShowSeats();
            showSeats.stream().map(showSeat -> ShowSeatStatus.AVAILABLE);
            for (ShowSeat showSeat : showSeats){
                showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
                showSeatService.updtateShowSeat(showSeat);
            }
            return null;
        }
        return null;
    }

    public Ticket getTicketById(int id){
        return ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException("Ticket is not found"));
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    public void deleteTicketById(int id){
        ticketRepository.deleteById(id);
    }

}

