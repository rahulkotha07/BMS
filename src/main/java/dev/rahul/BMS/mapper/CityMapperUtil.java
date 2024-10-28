package dev.rahul.BMS.mapper;

import dev.rahul.BMS.dto.CityDto;
import dev.rahul.BMS.model.City;
import dev.rahul.BMS.model.Ticket;

public class CityMapperUtil {

    public static City dtoToModel(CityDto cityDto){
        City city = new City();
        city.setName(cityDto.getName());
        return city;
    }

    public static CityDto modelToDto(City city){
        CityDto cityDto = new CityDto();
        cityDto.setName(city.getName());
        cityDto.setId(city.getId());
        return cityDto;
    }
}
