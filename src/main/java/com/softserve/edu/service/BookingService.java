package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.domain.Booking;

public interface BookingService {

    public void add(Booking booking);

    public void update(Booking booking);

    public Booking getById(Integer id);

    public List<Booking> getAll();

    public void delete(Booking booking);

}
