package com.softserve.edu.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL, mappedBy="country")
    Set<City> cities = new HashSet<>();
    
    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL, mappedBy="country")
    Set<Tour> tours = new HashSet<>();
    
    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL, mappedBy="country")
    Set<Visa> visas = new HashSet<>();
    
    public Set<Visa> getVisas() {
        return visas;
    }

    public void setVisas(Set<Visa> visas) {
        this.visas = visas;
    }

    @Column(name = "name")
    private String name;

    public Country() {
        
    }
    
    public Country(String name) {
        this.name = name;
       
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

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public Set<Tour> getTours() {
        return tours;
    }

    public void setTours(Set<Tour> tours) {
        this.tours = tours;
    }

   
}
