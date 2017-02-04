package com.softserve.edu.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @Column(name = "hotel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL, mappedBy="hotel")
    Set<HotelRoom> hotelRooms = new HashSet<>();
    
    
    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;
    
    
    
    @Column(name = "name")
    private String name;

    @Column(name = "rooms_count")
    private int roomsCount;

   

    public Hotel() {
    }

    public Hotel(String name, int roomsCount,City city) {

        this.name = name;
        this.roomsCount = roomsCount;
        this.city=city;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<HotelRoom> getHotelRooms() {
        return hotelRooms;
    }

    public void setHotelRooms(Set<HotelRoom> hotelRooms) {
        this.hotelRooms = hotelRooms;
    }
}
