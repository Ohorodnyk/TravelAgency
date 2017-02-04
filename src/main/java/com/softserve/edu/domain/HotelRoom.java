package com.softserve.edu.domain;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="hotel_rooms")
public class HotelRoom {
  
    @Id
    @Column(name="room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotel;
    
    
    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL, mappedBy="room")
    Set<Booking> booking = new HashSet<>();
    
    public HotelRoom(String name,Hotel hotel) {
        super();
        this.hotel = hotel;
        this.name = name;
    }

    @Column(name="name")
    private String name;
    
    public HotelRoom(){
        
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Set<Booking> getBooking() {
        return booking;
    }

    public void setBooking(Set<Booking> booking) {
        this.booking = booking;
    }

   
    
}
