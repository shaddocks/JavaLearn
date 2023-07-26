package com.lulu.spring.controller;

import com.lulu.spring.service.CountryService;
import com.lulu.spring.bean.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class CountryController {

    CountryService countryService;

    @Autowired
    @Qualifier("countryService")
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    public Country getCountryById(String id) {
        return countryService.getCountryById(id);
    }

    public Integer deleteCountryById(String id) {
        return countryService.deleteCountryById(id);
    }

    public Integer insertCountry(Country country) {
        return countryService.insertCountry(country);
    }
}
