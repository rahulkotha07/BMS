package dev.rahul.BMS.dto;

import dev.rahul.BMS.model.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TicketDto {
    private List<Integer> showSeatIds;
    private int userId;

}
