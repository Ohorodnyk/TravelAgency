package com.softserve.edu.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.softserve.edu.dao.ClientTourDao;
import com.softserve.edu.domain.ClientTour;

@Repository
@Transactional
public class ClientTourDaoImpl extends GenericDaoImpl<ClientTour> implements ClientTourDao {

    public ClientTourDaoImpl() {
        super(ClientTour.class);
    }

    public ClientTourDaoImpl(Class<ClientTour> genericClass) {
        super(genericClass);

    }

}
