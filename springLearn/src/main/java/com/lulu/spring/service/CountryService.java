package com.lulu.spring.service;

import com.lulu.spring.bean.Country;

public interface CountryService {
    Country getCountryById(String id);

    Integer deleteCountryById(String id);

    Integer insertCountry(Country country);
}
