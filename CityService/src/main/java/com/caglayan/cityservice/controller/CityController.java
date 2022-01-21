package com.caglayan.cityservice.controller;

import com.caglayan.cityservice.entity.City;
import com.caglayan.cityservice.repository.CityRepository;
import com.caglayan.cityservice.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/{id}")
    public String getCityById(@PathVariable("id") long id){
        return cityService.getCityById(id).getName();
    }

    @GetMapping
    public List<City> getAllCities(){
        return cityService.getAllCities();
    }
}
