package com.softserve.edu.dao;

import com.softserve.edu.domain.Client;

public interface ClientDao extends GenericDao<Client> {

    public abstract Client find(String firstName, String lastName);

}
