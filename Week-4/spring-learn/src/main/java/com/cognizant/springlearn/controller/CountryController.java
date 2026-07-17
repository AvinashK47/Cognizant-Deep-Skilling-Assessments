package com.cognizant.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @Autowired
    @Qualifier("in")
    private Country india;

    public CountryController() {
        LOGGER.debug("Inside CountryController Constructor.");
    }

    @GetMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START getCountryIndia");
        LOGGER.info("END getCountryIndia");
        return india;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("START getAllCountries");
        List<Country> list = countryService.getAllCountries();
        LOGGER.info("END getAllCountries");
        return list;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START getCountry controller: {}", code);
        Country match = countryService.getCountry(code);
        LOGGER.info("END getCountry controller");
        return match;
    }
}
