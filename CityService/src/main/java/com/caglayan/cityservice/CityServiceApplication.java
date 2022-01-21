package com.caglayan.cityservice;

import com.caglayan.cityservice.entity.City;
import com.caglayan.cityservice.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CityServiceApplication implements CommandLineRunner {

    private final CityService cityService;

    @Autowired
    public CityServiceApplication(CityService cityService) {
        this.cityService = cityService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CityServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cityService.insertCity(new City(1001L, "Ankara"));
        cityService.insertCity(new City(1002L, "İstanbul"));
        cityService.insertCity(new City(1003L, "İzmir"));
    }
}
