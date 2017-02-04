package com.softserve.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.edu.dao.CountryDao;
import com.softserve.edu.domain.Country;
import com.softserve.edu.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    @Override
    public void add(Country country) {
        countryDao.add(country);

    }

    @Override
    public void update(Country country) {
        countryDao.update(country);

    }

    @Override
    public Country getById(Integer id) {
        // TODO Auto-generated method stub
        return countryDao.getById(id);
    }

    @Override
    public List<Country> getAll() {
        return countryDao.getAllElements();
    }

    @Override
    public void delete(Country country) {
        countryDao.delete(country);

    }

    @Override
    public List<Country> findVisited(String firstName, String lastName) {

        return countryDao.findVisited(firstName, lastName);

    }

}
