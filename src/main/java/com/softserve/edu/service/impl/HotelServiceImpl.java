package com.softserve.edu.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.edu.dao.HotelDao;
import com.softserve.edu.domain.Hotel;
import com.softserve.edu.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelDao hotelDao;

	@Override
	public void add(Hotel hotel) {
		hotelDao.add(hotel);

	}

	@Override
	public void update(Hotel hotel) {
		hotelDao.update(hotel);

	}

	@Override
	public Hotel getById(Integer id) {
		return hotelDao.getById(id);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelDao.getAllElements();
	}

	@Override
	public void delete(Hotel hotel) {
		hotelDao.delete(hotel);
	}

	@Override
	public Set<Hotel> findHotels(String city) {

		return hotelDao.findHotels(city);
	}

	@Override
	public int findCountOfFreeRooms(String hotel, Date date) {

		return hotelDao.findCountOfFreeRooms(hotel, date);
	}

	@Override
	public List<Object[]> findFree(String city, Date date) {

		return hotelDao.findFree(city, date);
	}

	@Override
	public int findCountOfClients(String hotel) {

		return hotelDao.findCountOfClients(hotel);
	}

	@Override
	public int averageTimeOfBooking(String hotel) {

		return hotelDao.averageTimeOfBooking(hotel);
	}

}
