package dev.rahul.BMS.mapper;

import dev.rahul.BMS.dto.AuditoriumWithSeatsDto;
import dev.rahul.BMS.model.Auditorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuditoriumWithSeatsMapperUtil {

    @Autowired
    private TheatreMapperUtil theatreMapperUtil;

    public static AuditoriumWithSeatsDto modelToDto(Auditorium auditorium){
        AuditoriumWithSeatsDto auditoriumDto = new AuditoriumWithSeatsDto();
        auditoriumDto.setName(auditorium.getName());
        auditoriumDto.setAuditoriumFeatures(auditorium.getAuditoriumFeatures());
        auditoriumDto.setId(auditorium.getId());
        auditoriumDto.setCapacity(auditorium.getCapacity());
        auditoriumDto.setSeats(auditorium.getSeats());
        auditoriumDto.setTheatreDto(TheatreMapperUtil.modelToDto(auditorium.getTheatre()));
        return auditoriumDto;
    }
    public Auditorium dtoToModel(AuditoriumWithSeatsDto auditoriumDto){
        Auditorium auditorium = new Auditorium();
        auditorium.setName(auditoriumDto.getName());
        auditorium.setSeats(auditoriumDto.getSeats());
        auditorium.setAuditoriumFeatures(auditoriumDto.getAuditoriumFeatures());
        auditorium.setTheatre(theatreMapperUtil.dtoToModel(auditoriumDto.getTheatreDto()));
        auditorium.setCapacity(auditoriumDto.getCapacity());
        return auditorium;
    }
}
