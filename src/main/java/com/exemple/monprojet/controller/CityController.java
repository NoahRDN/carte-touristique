package com.exemple.monprojet.controller;

import org.springframework.web.bind.annotation.*;

import com.exemple.monprojet.model.City;
import com.exemple.monprojet.repository.CityRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CityController {

    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/cities")
    public List<City> getCitiesByCountry(@RequestParam String pays) {
        return cityRepository.findByPays_Code(pays);
    }
}