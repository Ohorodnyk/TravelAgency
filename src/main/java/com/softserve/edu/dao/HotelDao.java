package com.softserve.edu.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.softserve.edu.domain.Hotel;

public interface HotelDao extends GenericDao<Hotel> {

    public abstract Set<Hotel> findHotels(String city);

    public abstract int findCountOfFreeRooms(String hotel, Date date);

    public abstract List<Object[]> findFree(String city, Date date);

    public abstract int findCountOfClients(String hotel);

    public abstract int averageTimeOfBooking(String hotel);

}
