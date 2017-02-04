package com.softserve.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.edu.dao.ClientDao;
import com.softserve.edu.domain.Client;
import com.softserve.edu.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientDao clientDao;

	@Override
	public void add(Client client) {
		clientDao.add(client);

	}

	@Override
	public void update(Client client) {
		clientDao.update(client);

	}

	@Override
	public Client getById(Integer id) {

		return clientDao.getById(id);
	}

	@Override
	public List<Client> getAll() {

		return clientDao.getAllElements();
	}

	@Override
	public void delete(Client client) {
		clientDao.delete(client);

	}

	@Override
	public Client find(String firstName, String lastName) {

		return clientDao.find(firstName, lastName);
	}

}
