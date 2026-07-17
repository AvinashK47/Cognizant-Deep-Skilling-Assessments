package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    @Autowired
    @Qualifier("countryList")
    private List<Country> countryList;

    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("START getCountry: {}", code);
        Country match = countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> {
                    LOGGER.error("Country not found: {}", code);
                    return new CountryNotFoundException();
                });
        LOGGER.info("END getCountry: {}", match);
        return match;
    }
    
    public List<Country> getAllCountries() {
        return countryList;
    }
}
