package com.softserve.edu.service;

import java.util.List;
import java.util.Set;

import com.softserve.edu.domain.Visa;

public interface VisaService {
	public void add(Visa visa);

	public void update(Visa visa);

	public Visa getById(Integer id);

	public List<Visa> getAllElements();

	public void delete(Visa visa);

	public Set<Visa> find(String firstName, String lastName);

	public int countOfVisas(String country);

	public List<Visa> findValid(String firstName, String lastName, String country);

}
