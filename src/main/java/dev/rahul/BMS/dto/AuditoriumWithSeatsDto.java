package dev.rahul.BMS.dto;


import dev.rahul.BMS.model.Seat;
import dev.rahul.BMS.model.constants.AuditoriumFeature;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuditoriumWithSeatsDto {
    private int id;
    private String name;
    private int capacity;
    private List<Seat> seats;
    private List<AuditoriumFeature> auditoriumFeatures;
    private TheatreDto theatreDto;
}
