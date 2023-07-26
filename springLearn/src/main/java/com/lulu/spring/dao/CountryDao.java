package com.lulu.spring.dao;

import com.lulu.spring.bean.Country;

public interface CountryDao {
    Country getCountryById(String id);

    Integer deleteCountryById(String id);

    Integer insertCountry(Country country);
}
