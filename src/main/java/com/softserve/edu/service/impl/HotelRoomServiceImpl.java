package com.softserve.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.edu.dao.HotelRoomDao;
import com.softserve.edu.domain.HotelRoom;
import com.softserve.edu.service.HotelRoomService;

@Service
public class HotelRoomServiceImpl implements HotelRoomService {
	@Autowired
	HotelRoomDao hotelRoomDao;

	@Override
	public void add(HotelRoom hotelRoom) {
		hotelRoomDao.add(hotelRoom);

	}

	@Override
	public void update(HotelRoom hotelRoom) {
		hotelRoomDao.update(hotelRoom);

	}

	@Override
	public HotelRoom getById(Integer id) {

		return hotelRoomDao.getById(id);
	}

	@Override
	public List<HotelRoom> getAllElements() {

		return hotelRoomDao.getAllElements();
	}

	@Override
	public void delete(HotelRoom hotelRoom) {
		hotelRoomDao.delete(hotelRoom);

	}

}
