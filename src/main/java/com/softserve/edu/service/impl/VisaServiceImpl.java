package com.softserve.edu.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.edu.dao.VisaDao;
import com.softserve.edu.domain.Visa;
import com.softserve.edu.service.VisaService;

@Service
public class VisaServiceImpl implements VisaService {

	@Autowired
	VisaDao visaDao;

	@Override
	public void add(Visa visa) {
		visaDao.add(visa);
	}

	@Override
	public void update(Visa visa) {
		visaDao.update(visa);

	}

	@Override
	public Visa getById(Integer id) {

		return visaDao.getById(id);
	}

	@Override
	public List<Visa> getAllElements() {

		return visaDao.getAllElements();
	}

	@Override
	public void delete(Visa visa) {
		visaDao.delete(visa);

	}

	@Override
	public Set<Visa> find(String firstName, String lastName) {
		return visaDao.find(firstName, lastName);
	}

	@Override
	public int countOfVisas(String country) {

		return visaDao.countOfVisas(country);
	}

	@Override
	public List<Visa> findValid(String firstName, String lastName, String country) {

		return visaDao.findValid(firstName, lastName, country);
	}

}
