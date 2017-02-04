package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.domain.Tour;

public interface TourService {
    public void add(Tour tour);

    public void update(Tour tour);

    public Tour getById(Integer id);

    public List<Tour> getAllElements();

    public void delete(Tour tour);
}
