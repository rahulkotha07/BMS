package dev.rahul.BMS.mapper;

import dev.rahul.BMS.dto.TicketResponseDto;
import dev.rahul.BMS.model.ShowSeat;
import dev.rahul.BMS.model.Ticket;
import java.util.ArrayList;
import java.util.List;

public class TicketMapperUtil {

    public static TicketResponseDto modelToDto(Ticket ticket){
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        ticketResponseDto.setId(ticket.getId());
        ticketResponseDto.setMovieName(ticket.getShow().getMovie().getName());
        ticketResponseDto.setAuditoriumName(ticket.getShow().getAuditorium().getName());
        ticketResponseDto.setUserName(ticket.getUser().toString());
        ticketResponseDto.setLanguage(ticket.getShow().getLanguage());
        ticketResponseDto.setStartTime(ticket.getShow().getStartTime().toString());
        ticketResponseDto.setEndTime(ticket.getShow().getEndTime().toString());

        List<ShowSeat> showSeats = ticket.getShowSeats();
        List<String> seatNumbers = new ArrayList<>();
        for(ShowSeat showSeat : showSeats){
            seatNumbers.add(showSeat.getSeat().getSeatNumber());
        }
        ticketResponseDto.setSeatNumbers(seatNumbers);
        ticketResponseDto.setCost(ticket.getCost());
        return ticketResponseDto;

    }
}
