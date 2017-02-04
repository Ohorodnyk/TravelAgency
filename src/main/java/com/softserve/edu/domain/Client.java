package com.softserve.edu.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL, mappedBy="client")
    Set<Visa> visas = new HashSet<>();
    
    
    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL, mappedBy="client")
    Set<ClientTour> clientTours = new HashSet<>();

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "lastName", length = 50)
    private String lastName;

    public Client() {
    }

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Visa> getVisas() {
        return visas;
    }

    public void setVisas(Set<Visa> visas) {
        this.visas = visas;
    }

    public Set<ClientTour> getClientTours() {
        return clientTours;
    }

    public void setClientTours(Set<ClientTour> clientTours) {
        this.clientTours = clientTours;
    }

   
}
