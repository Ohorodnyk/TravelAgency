package com.softserve.edu.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.softserve.edu.domain.Hotel;

public interface HotelService {
	public void add(Hotel hotel);

	public void update(Hotel hotel);

	public Hotel getById(Integer id);

	public List<Hotel> getAll();

	public void delete(Hotel hotel);

	public Set<Hotel> findHotels(String city);

	public int findCountOfFreeRooms(String hotel, Date date);

	public List<Object[]> findFree(String city, Date date);

	public int findCountOfClients(String hotel);

	public int averageTimeOfBooking(String hotel);

}
