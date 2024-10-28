package dev.rahul.BMS.mapper;

import dev.rahul.BMS.dto.TheatreDto;
import dev.rahul.BMS.dto.TheatreRequestDto;
import dev.rahul.BMS.model.Theatre;
import dev.rahul.BMS.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TheatreMapperUtil {

    @Autowired
    private CityService cityService;

    public Theatre dtoToModel(TheatreRequestDto theatreRequestDto){
        Theatre theatre = new Theatre();
        theatre.setName(theatreRequestDto.getName());
        theatre.setCity(cityService.getCityById(theatreRequestDto.getCityId()));
        return theatre;
    }

    public Theatre dtoToModel(TheatreDto theatreDto){
        Theatre theatre = new Theatre();
        theatre.setName(theatreDto.getName());
        theatre.setId(theatreDto.getId());
        theatre.setCity(cityService.getCityById(theatreDto.getCityDto().getId()));
        return theatre;
    }

    public static TheatreDto modelToDto(Theatre theatre){
        TheatreDto theatreDto= new TheatreDto();
        theatreDto.setName(theatre.getName());
        theatreDto.setId(theatre.getId());
        theatreDto.setCityDto(CityMapperUtil.modelToDto(theatre.getCity()));
        return theatreDto;
    }
}
