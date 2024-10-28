package dev.rahul.BMS.mapper;

import dev.rahul.BMS.dto.AuditoriumDto;
import dev.rahul.BMS.dto.AuditoriumRequestDto;
import dev.rahul.BMS.model.Auditorium;
import dev.rahul.BMS.service.TheatreService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuditoriumMapperUtil {

    @Autowired
    private TheatreMapperUtil theatreMapperUtil;
    @Autowired
    private TheatreService theatreService;

    public static AuditoriumDto modelToDto(Auditorium auditorium){
        AuditoriumDto auditoriumDto = new AuditoriumDto();
        auditoriumDto.setName(auditorium.getName());
        auditoriumDto.setAuditoriumFeatures(auditorium.getAuditoriumFeatures());
        auditoriumDto.setId(auditorium.getId());
        auditoriumDto.setCapacity(auditorium.getCapacity());
        //auditoriumDto.setSeats(auditorium.getSeats());
        auditoriumDto.setTheatreDto(TheatreMapperUtil.modelToDto(auditorium.getTheatre()));
        return auditoriumDto;
    }
    public Auditorium dtoToModel(AuditoriumRequestDto auditoriumRequestDto){
        Auditorium auditorium = new Auditorium();
        auditorium.setName(auditoriumRequestDto.getName());
        //auditorium.setSeats(auditoriumDto.getSeats());
        auditorium.setTheatre(theatreService.getTheatreById(auditoriumRequestDto.getTheatreId()));
        auditorium.setCapacity(auditoriumRequestDto.getCapacity());
        return auditorium;
    }
}
