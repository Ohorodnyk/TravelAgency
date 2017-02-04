package com.softserve.edu.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @Column(name = "tour_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;
    
   
    @ManyToOne
    @JoinColumn(name="city_id")
    private City  city;
  
    
    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL, mappedBy="tour")
    Set<ClientTour> clientTours = new HashSet<>();
      

    public Tour() {
    }
    
    public Tour(String name, String description, Country country, City city) {
        super();
        this.country = country;
        this.city = city;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Country getCountry() {
        return country;
    }


    public void setCountry(Country country) {
        this.country = country;
    }


    public City getCity() {
        return city;
    }


    public void setCity(City city) {
        this.city = city;
    }

    public Set<ClientTour> getClientTours() {
        return clientTours;
    }

    public void setClientTours(Set<ClientTour> clientTours) {
        this.clientTours = clientTours;
    }
}
