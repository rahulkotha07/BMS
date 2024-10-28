package dev.rahul.BMS.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditoriumRequestDto {

    private String name;
    private int capacity;
    private int theatreId;
}
