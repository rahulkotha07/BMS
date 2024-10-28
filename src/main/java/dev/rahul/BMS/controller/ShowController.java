package dev.rahul.BMS.controller;

import dev.rahul.BMS.dto.ShowRequestDto;
import dev.rahul.BMS.dto.ShowResponseDto;
import dev.rahul.BMS.mapper.ShowMapperUtil;
import dev.rahul.BMS.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShowController {
    @Autowired
    private ShowService showService;
    @Autowired
    private ShowMapperUtil showMapperUtil;

    @PostMapping("/show")
    public ResponseEntity<ShowResponseDto> createShow(@RequestBody ShowRequestDto showRequestDto){
        return ResponseEntity.ok(showMapperUtil.modelToDto(showService.createShow(showMapperUtil.dtoToModel(showRequestDto))));
    }

    @GetMapping("/show//{id}")
    public ResponseEntity<ShowResponseDto> getShowById(@PathVariable("id") int id){
        return ResponseEntity.ok(showMapperUtil.modelToDto(showService.getShowById(id)));
    }
}
