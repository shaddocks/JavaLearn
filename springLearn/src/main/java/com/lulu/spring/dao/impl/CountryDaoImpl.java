package com.lulu.spring.dao.impl;

import com.lulu.spring.bean.Country;
import com.lulu.spring.dao.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDaoImpl implements CountryDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Country getCountryById(String id) {
        String sql = "select * from countries where country_id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Country country = new Country();
            return country.setCountryId(rs.getString("country_id"))
                    .setCountryName(rs.getString("country_name"))
                    .setRegionId(rs.getInt("region_id"));
        }, id);
    }

    @Override
    public Integer deleteCountryById(String id) {
        String sql = "delete from countries where country_id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Integer insertCountry(Country country) {
        String sql = "insert into countries(country_id, country_name, region_id) values(?, ?, ?)";
        return jdbcTemplate.update(sql, country.getCountryId(), country.getCountryName(), country.getRegionId());
    }
}
