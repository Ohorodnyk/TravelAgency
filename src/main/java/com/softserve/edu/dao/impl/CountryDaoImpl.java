package com.softserve.edu.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.softserve.edu.dao.CountryDao;
import com.softserve.edu.domain.Country;

@Repository
@Transactional
public class CountryDaoImpl extends GenericDaoImpl<Country> implements CountryDao {

    public CountryDaoImpl() {
        super(Country.class);
    }

    public CountryDaoImpl(Class<Country> genericClass) {
        super(genericClass);

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Country> findVisited(String firstName, String lastName) {

        List<Country> countries = null;
        Query query = sessionFactory.getCurrentSession().createQuery("Select t.tour.country from ClientTour t where "
                + " t.client.firstName =:fName and t.client.lastName =:lName");
        query.setParameter("fName", firstName);
        query.setParameter("lName", lastName);
        countries = query.list();
        return countries;
    }

}
