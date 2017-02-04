package com.softserve.edu.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client_tours")
public class ClientTour {
    @Id
    @Column(name = "client_tour_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client; 
    
    
    @ManyToOne
    @JoinColumn(name="tour_id")
    private Tour tour;
    
   
    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL, mappedBy="clientTour")
    Set<Booking> booking = new HashSet<>();
    
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    

    public ClientTour() {
    }

    
    
    public ClientTour(Client client, Tour tour, Date startDate, Date endDate) {
        super();
        this.client = client;
        this.tour = tour;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    

    public int getId() {
        return Id;
    }

    public void setId(int clientTourId) {
        this.Id = clientTourId;
    }

   


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public Client getClient() {
        return client;
    }


    public void setClient(Client client) {
        this.client = client;
    }



    public Tour getTour() {
        return tour;
    }



    public void setTour(Tour tour) {
        this.tour = tour;
    }



    public Set<Booking> getBooking() {
        return booking;
    }


    public void setBooking(Set<Booking> booking) {
        this.booking = booking;
    }
}
