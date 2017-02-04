package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.domain.City;

public interface CityService {

    public void add(City city);

    public void update(City city);

    public City getById(Integer id);

    public List<City> getAll();

    public void delete(City city);

}
