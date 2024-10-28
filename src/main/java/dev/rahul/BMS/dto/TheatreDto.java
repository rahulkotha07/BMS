package dev.rahul.BMS.dto;

import dev.rahul.BMS.model.City;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class TheatreDto {
    private int id;
    private String name;
    private CityDto cityDto;
}
