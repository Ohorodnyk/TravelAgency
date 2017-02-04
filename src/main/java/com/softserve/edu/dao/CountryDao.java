package com.softserve.edu.dao;

import java.util.List;

import com.softserve.edu.domain.Country;

public interface CountryDao extends GenericDao<Country> {

    public abstract List<Country> findVisited(String firstName, String lastName);

}
