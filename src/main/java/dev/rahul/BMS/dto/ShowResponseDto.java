package dev.rahul.BMS.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ShowResponseDto {
    private int id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int auditoriumId;
    private String auditoriumName;
    private int movieId;
    private String movieName;
    private String language;
    private String showStatus;
}
