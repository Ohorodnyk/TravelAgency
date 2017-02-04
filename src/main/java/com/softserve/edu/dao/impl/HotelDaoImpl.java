package com.softserve.edu.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.softserve.edu.dao.HotelDao;
import com.softserve.edu.domain.City;
import com.softserve.edu.domain.Hotel;

@Repository
@Transactional
public class HotelDaoImpl extends GenericDaoImpl<Hotel> implements HotelDao {

    public HotelDaoImpl() {
        super(Hotel.class);
    }

    public HotelDaoImpl(Class<Hotel> genericClass) {
        super(genericClass);

    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<Hotel> findHotels(String city) {
        Set<Hotel> hotels = null;
        Query query = sessionFactory.getCurrentSession().createQuery("from City where name =:city");
        query.setParameter("city", city);
        List<City> list = query.list();
        if (list.size() > 0)
            hotels = list.get(0).getHotels();
        return hotels;
    }

    @Override
    public int findCountOfFreeRooms(String hotel, Date date) {
        int count = 0;
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select count(r.id) from Booking as b " + " inner join  b.room as r "
                        + " inner join  r.hotel as h " + " where h.name  =:hotel "
                        + " and  :date1 NOT BETWEEN b.startData AND b.endDate " + "AND  :date2 >b.endDate ");
        query.setParameter("hotel", hotel);
        query.setParameter("date1", date);
        query.setParameter("date2", date);
        List list = query.list();
        count = ((Number) list.get(0)).intValue();
        return count;

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> findFree(String city, Date date) {

        List<Object[]> list = null;
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select h.name, count(*) from Hotel as h "
                        + " inner join  h.city as c  with c.name = :city " + " left join  h.hotelRooms as hr "
                        + " left join hr.booking as b " + " where b.endDate is null "
                        + " OR :date NOT BETWEEN b.startData AND b.endDate " + "group by h.name");
        query.setParameter("city", city);
        query.setParameter("date", date);
        list = query.list();
        return list;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public int findCountOfClients(String hotel) {
        int count = 0;
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select count(distinct ct.id) from Booking as b  " + "inner join b.clientTour as ct "
                        + "inner join b.room as r " + "inner join r.hotel as h " + " where h.name= :hotel");
        query.setParameter("hotel", hotel);
        List list = query.list();
        count = ((Number) list.get(0)).intValue();
        return count;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public int averageTimeOfBooking(String hotel) {
        int days = 0;
        Query query = sessionFactory.getCurrentSession()
                .createSQLQuery("SELECT AVG( DATEDIFF(br.end_date, br.start_date) ) " + "FROM booking br "
                        + "JOIN client_tours ct ON br.client_tour_id=ct.client_tour_id "
                        + " JOIN hotel_rooms r on br.room_id=r.room_id " + "  JOIN hotels h on r.hotel_id=h.hotel_id "
                        + " WHERE h.name= :hotel");
        query.setParameter("hotel", hotel);
        List list = query.list();
        days = ((Number) list.get(0)).intValue();
        return days;
    }

}
