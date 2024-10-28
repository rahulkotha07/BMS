package dev.rahul.BMS.controller;

import dev.rahul.BMS.dto.AuditoriumDto;
import dev.rahul.BMS.dto.AuditoriumRequestDto;
import dev.rahul.BMS.dto.AuditoriumWithSeatsDto;
import dev.rahul.BMS.model.Auditorium;
import dev.rahul.BMS.service.AuditoriumService;
import dev.rahul.BMS.service.TheatreService;
import dev.rahul.BMS.mapper.AuditoriumMapperUtil;
import dev.rahul.BMS.mapper.AuditoriumWithSeatsMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AuditoriumController {
    @Autowired
    private AuditoriumService auditoriumService;
    @Autowired
    private TheatreService theatreService;
    @Autowired
    private AuditoriumMapperUtil auditoriumMapperUtil;

    @PostMapping("/auditorium")
    public ResponseEntity<AuditoriumDto> createAuditorium(@RequestBody AuditoriumRequestDto auditoriumRequestDto){
        Auditorium auditorium1 =  auditoriumService.createAuditorium(auditoriumMapperUtil.dtoToModel(auditoriumRequestDto));
        AuditoriumDto auditoriumDto = AuditoriumMapperUtil.modelToDto(auditorium1);
        return ResponseEntity.ok(auditoriumDto);
    }

    @GetMapping("/auditoriums/{id}")
    public ResponseEntity<List<AuditoriumDto>> getAuditoriumsByTheatre(@PathVariable("id") int id){
        List<Auditorium> auditoriums = auditoriumService.getAllAuditoriumsByTheatreId(id);
        List<AuditoriumDto> auditoriumDtos = new ArrayList<>();
        for(Auditorium auditorium : auditoriums){
            auditoriumDtos.add(AuditoriumMapperUtil.modelToDto(auditorium));
        }
        return ResponseEntity.ok(auditoriumDtos);
    }

    @GetMapping("/auditorium-with-seats/{id}")
    public ResponseEntity<AuditoriumWithSeatsDto> getAuditoriumWithSeats(@PathVariable("id") int id){
        Auditorium auditorium = auditoriumService.getAuditoriumById(id);
        AuditoriumWithSeatsDto auditoriumWithSeatsDto = AuditoriumWithSeatsMapperUtil.modelToDto(auditorium);
        return ResponseEntity.ok(auditoriumWithSeatsDto);
    }

}
