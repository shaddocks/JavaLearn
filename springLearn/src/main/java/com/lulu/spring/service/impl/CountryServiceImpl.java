package com.lulu.spring.service.impl;

import com.lulu.spring.service.CountryService;
import com.lulu.spring.bean.Country;
import com.lulu.spring.dao.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("countryService")
public class CountryServiceImpl implements CountryService {

    CountryDao countryDao;

    @Autowired
    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public Country getCountryById(String id) {
        return countryDao.getCountryById(id);
    }

    @Override
    public Integer deleteCountryById(String id) {
        return countryDao.deleteCountryById(id);
    }

    @Override
    public Integer insertCountry(Country country) {
        return countryDao.insertCountry(country);
    }
}
