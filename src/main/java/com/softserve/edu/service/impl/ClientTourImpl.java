package com.softserve.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.edu.dao.ClientTourDao;
import com.softserve.edu.domain.ClientTour;
import com.softserve.edu.service.ClientTourService;

@Service
public class ClientTourImpl implements ClientTourService {

	@Autowired
	private ClientTourDao clientTourDao;

	@Override
	public void add(ClientTour clientTour) {
		clientTourDao.add(clientTour);

	}

	@Override
	public void update(ClientTour clientTour) {
		clientTourDao.update(clientTour);

	}

	@Override
	public ClientTour getById(Integer id) {
		return clientTourDao.getById(id);
	}

	@Override
	public List<ClientTour> getAllElements() {

		return clientTourDao.getAllElements();
	}

	@Override
	public void delete(ClientTour clientTour) {
		clientTourDao.delete(clientTour);

	}

}
