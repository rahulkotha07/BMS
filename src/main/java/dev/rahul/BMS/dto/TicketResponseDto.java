package dev.rahul.BMS.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TicketResponseDto {
    private int id;
    private List<String> seatNumbers;
    private String userName;
    private String auditoriumName;
    private String movieName;
    private String language;
    private String startTime;
    private String endTime;
    private int cost;
}
