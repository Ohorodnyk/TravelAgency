package com.softserve.edu.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.softserve.edu.dao.CityDao;
import com.softserve.edu.domain.City;

@Repository
@Transactional
public class CityDaoImpl extends GenericDaoImpl<City> implements CityDao {

    public CityDaoImpl() {
        super(City.class);
    }

    public CityDaoImpl(Class<City> genericClass) {
        super(genericClass);

    }

}
