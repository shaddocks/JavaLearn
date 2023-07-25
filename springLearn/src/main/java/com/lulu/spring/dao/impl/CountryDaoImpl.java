package com.lulu.spring.dao.impl;

import com.lulu.spring.bean.Country;
import com.lulu.spring.dao.CountryDao;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDaoImpl implements CountryDao {
    @Override
    public Country getCountryById(int id) {
        return new Country();
    }
}
