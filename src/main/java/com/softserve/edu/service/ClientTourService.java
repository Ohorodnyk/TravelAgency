package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.domain.ClientTour;

public interface ClientTourService {
    public void add(ClientTour clientTour);

    public void update(ClientTour clientTour);

    public ClientTour getById(Integer id);

    public List<ClientTour> getAllElements();

    public void delete(ClientTour clientTour);
}
