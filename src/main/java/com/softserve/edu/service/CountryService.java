package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.domain.Country;

public interface CountryService {

    public void add(Country country);

    public void update(Country country);

    public Country getById(Integer id);

    public List<Country> getAll();

    public void delete(Country country);

    public List<Country> findVisited(String firstName, String lastName);

}
