package dev.rahul.BMS.dto;

import dev.rahul.BMS.model.Auditorium;
import dev.rahul.BMS.model.Movie;
import dev.rahul.BMS.model.ShowSeat;
import dev.rahul.BMS.model.constants.ShowStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ShowRequestDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int auditoriumId;
    private int movieId;
    private String language;
}
