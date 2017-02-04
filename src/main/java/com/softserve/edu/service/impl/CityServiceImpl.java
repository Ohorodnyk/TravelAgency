package com.softserve.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.edu.dao.CityDao;
import com.softserve.edu.domain.City;
import com.softserve.edu.service.CityService;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public void add(City city) {
        cityDao.add(city);
    }

    public void update(City city) {
        cityDao.add(city);
    }

    public City getById(Integer id) {
        return cityDao.getById(id);

    }

    public List<City> getAll() {

        return cityDao.getAllElements();
    }

    public void delete(City city) {
        cityDao.delete(city);
    }

}
