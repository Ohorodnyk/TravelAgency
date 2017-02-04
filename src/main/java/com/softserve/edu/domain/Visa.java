package com.softserve.edu.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "visas")
public class Visa {
    @Id
    @Column(name = "visa_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    
    
    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

   
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public Visa(){
        
    }
    
    
    public Visa(Client client, Country country, Date startDate, Date endDate) {
        super();
        this.client = client;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
