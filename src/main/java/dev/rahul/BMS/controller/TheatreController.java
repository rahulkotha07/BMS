package dev.rahul.BMS.controller;

import dev.rahul.BMS.dto.TheatreDto;
import dev.rahul.BMS.dto.TheatreRequestDto;
import dev.rahul.BMS.model.Theatre;
import dev.rahul.BMS.service.TheatreService;
import dev.rahul.BMS.mapper.TheatreMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TheatreController {

    @Autowired
    private TheatreService theatreService;
    @Autowired
    private TheatreMapperUtil theatreMapperUtil;

    @PostMapping("/theatre")
    public ResponseEntity<TheatreDto> createTheatre(@RequestBody TheatreRequestDto theatreRequestDto){
        Theatre theatre1 = theatreService.createTheatre(theatreMapperUtil.dtoToModel(theatreRequestDto));
        TheatreDto theatreDto = TheatreMapperUtil.modelToDto(theatre1);
        return ResponseEntity.ok(theatreDto);
    }

    @GetMapping("/theatre/{id}")
    public ResponseEntity<List<TheatreDto>> getTheatreByCity(@PathVariable("id") int id){
        List<Theatre> theatres =  theatreService.getAllTheatresByCityId(id);
        List<TheatreDto> theatreDtos = new ArrayList<>();
        for (Theatre theatre : theatres){
            theatreDtos.add(TheatreMapperUtil.modelToDto(theatre));
        }
        return ResponseEntity.ok(theatreDtos);
    }
    @GetMapping("/theatre")
    public ResponseEntity<List<TheatreDto>> getAllTheatres(){
        List<Theatre> theatres =  theatreService.getAllTheatres();
        List<TheatreDto> theatreDtos = new ArrayList<>();
        for (Theatre theatre : theatres){
            theatreDtos.add(TheatreMapperUtil.modelToDto(theatre));
        }
        return ResponseEntity.ok(theatreDtos);
    }
}
