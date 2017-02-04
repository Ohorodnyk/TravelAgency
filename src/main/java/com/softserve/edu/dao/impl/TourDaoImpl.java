package com.softserve.edu.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.softserve.edu.dao.TourDao;
import com.softserve.edu.domain.Tour;

@Repository
@Transactional
public class TourDaoImpl extends GenericDaoImpl<Tour> implements TourDao {

    public TourDaoImpl() {
        super(Tour.class);
    }

    public TourDaoImpl(Class<Tour> genericClass) {
        super(genericClass);

    }

}
