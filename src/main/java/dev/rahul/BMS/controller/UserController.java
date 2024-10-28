package dev.rahul.BMS.controller;

import dev.rahul.BMS.dto.UserRequestDto;
import dev.rahul.BMS.dto.UserResponseDto;
import dev.rahul.BMS.mapper.UserMapperUtil;
import dev.rahul.BMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(UserMapperUtil.modelToDto(userService.createUser(UserMapperUtil.dtoToModel(userRequestDto))));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") int id){
        return ResponseEntity.ok(UserMapperUtil.modelToDto(userService.getUserById(id)));
    }

}
