package com.caglayan.cityservice.service;

import com.caglayan.cityservice.entity.City;
import com.caglayan.cityservice.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City insertCity(City city){
        return cityRepository.save(city);
    }

    public City getCityById(long id){
        Optional<City> cityDb = cityRepository.findById(id);

        return cityDb.orElse(new City());
    }

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }
}
