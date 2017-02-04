package com.softserve.edu.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.softserve.edu.dao.ClientDao;
import com.softserve.edu.domain.Client;

@Repository
@Transactional
public class ClientDaoImpl extends GenericDaoImpl<Client> implements ClientDao {

    public ClientDaoImpl() {
        super(Client.class);
    }

    public ClientDaoImpl(Class<Client> genericClass) {
        super(genericClass);

    }

    @Override
    public Client find(String firstName, String lastName) {
        Client client = null;
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Client where firstName =:fName and lastName =:lName");
        query.setParameter("fName", firstName);
        query.setParameter("lName", lastName);
        List<Client> list = query.list();
        if (list.size() > 0)
            client = list.get(0);
        return client;
    }

}
