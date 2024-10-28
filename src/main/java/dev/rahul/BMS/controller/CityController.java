package dev.rahul.BMS.controller;

import dev.rahul.BMS.dto.CityDto;
import dev.rahul.BMS.model.City;
import dev.rahul.BMS.service.CityService;
import dev.rahul.BMS.mapper.CityMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/city")
    public ResponseEntity<CityDto> createCity(@RequestBody City city){
        City savedCity = cityService.createCity(city);
        CityDto cityDto = CityMapperUtil.modelToDto(savedCity);
        return ResponseEntity.ok(cityDto);
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<CityDto> getCityById(@PathVariable("id") int id){
        City city = cityService.getCityById(id);
        CityDto cityDto = CityMapperUtil.modelToDto(city);
        return ResponseEntity.ok(cityDto);
    }

    @GetMapping("/city")
    public ResponseEntity<List<CityDto>> getAllCities(){
        List<City> cities = cityService.getAllCities();
        List<CityDto> cityDtos = new ArrayList<>();
        for(City city : cities){
            cityDtos.add(CityMapperUtil.modelToDto(city));
        }
        return ResponseEntity.ok(cityDtos);
    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity<String> deleteCityById(@PathVariable("id") int id){
        cityService.deleteCityById(id);
        return ResponseEntity.ok("City Deleted");
    }

}
