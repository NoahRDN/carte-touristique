package com.exemple.monprojet.controller;
import org.springframework.web.bind.annotation.*;

import com.exemple.monprojet.model.Country;
import com.exemple.monprojet.repository.CountryRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
