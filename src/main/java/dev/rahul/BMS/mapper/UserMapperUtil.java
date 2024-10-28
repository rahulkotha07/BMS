package dev.rahul.BMS.mapper;

import dev.rahul.BMS.dto.UserRequestDto;
import dev.rahul.BMS.dto.UserResponseDto;
import dev.rahul.BMS.model.User;

public class UserMapperUtil {

    public static User dtoToModel(UserRequestDto userRequestDto){
        User user = new User();
        user.setEmail(userRequestDto.getEmail());
        user.setName(userRequestDto.getName());
        return user;
    }

    public static UserResponseDto modelToDto(User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
