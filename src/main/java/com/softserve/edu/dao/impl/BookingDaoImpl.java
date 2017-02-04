package com.softserve.edu.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.softserve.edu.dao.BookingDao;
import com.softserve.edu.domain.Booking;

@Repository
@Transactional
public class BookingDaoImpl extends GenericDaoImpl<Booking> implements BookingDao {

    public BookingDaoImpl() {
        super(Booking.class);
    }

    public BookingDaoImpl(Class<Booking> genericClass) {
        super(genericClass);

    }

}
