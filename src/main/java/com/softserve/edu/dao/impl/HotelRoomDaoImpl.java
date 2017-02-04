package com.softserve.edu.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.softserve.edu.dao.HotelRoomDao;
import com.softserve.edu.domain.HotelRoom;

@Repository
@Transactional
public class HotelRoomDaoImpl extends GenericDaoImpl<HotelRoom> implements HotelRoomDao {

    public HotelRoomDaoImpl() {
        super(HotelRoom.class);
    }

    public HotelRoomDaoImpl(Class<HotelRoom> genericClass) {
        super(genericClass);

    }
}
