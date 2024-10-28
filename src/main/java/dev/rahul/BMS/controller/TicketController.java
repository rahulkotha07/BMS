package dev.rahul.BMS.controller;

import dev.rahul.BMS.dto.TicketDto;
import dev.rahul.BMS.dto.TicketResponseDto;
import dev.rahul.BMS.mapper.TicketMapperUtil;
import dev.rahul.BMS.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/ticket")
    public ResponseEntity<TicketResponseDto> createTicket(@RequestBody TicketDto ticketDto){
        return ResponseEntity.ok(TicketMapperUtil.modelToDto(ticketService.createTicket(ticketDto)));
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<TicketResponseDto> getTicketById(@PathVariable("id") int id){
        return ResponseEntity.ok(TicketMapperUtil.modelToDto(ticketService.getTicketById(id)));
    }
}
