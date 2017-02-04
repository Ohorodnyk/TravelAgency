package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.domain.HotelRoom;

public interface HotelRoomService {
	public void add(HotelRoom hotelRoom);

	public void update(HotelRoom hotelRoom);

	public HotelRoom getById(Integer id);

	public List<HotelRoom> getAllElements();

	public void delete(HotelRoom hotelRoom);
}
