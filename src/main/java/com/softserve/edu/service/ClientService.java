package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.domain.Client;

public interface ClientService {

    public void add(Client client);

    public void update(Client client);

    public Client getById(Integer id);

    public List<Client> getAll();

    public void delete(Client client);

    public Client find(String firstName, String lastName);

}
