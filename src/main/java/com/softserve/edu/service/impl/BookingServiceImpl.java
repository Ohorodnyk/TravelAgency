package com.softserve.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.edu.dao.BookingDao;
import com.softserve.edu.domain.Booking;
import com.softserve.edu.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public void add(Booking booking) {
        bookingDao.add(booking);

    }

    @Override
    public void update(Booking booking) {
        bookingDao.delete(booking);

    }

    @Override
    public Booking getById(Integer id) {
        return bookingDao.getById(id);
    }

    @Override
    public List<Booking> getAll() {

        return bookingDao.getAllElements();

    }

    @Override
    public void delete(Booking booking) {
        bookingDao.delete(booking);

    }

}
