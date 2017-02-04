package com.softserve.edu.dao.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.softserve.edu.dao.VisaDao;
import com.softserve.edu.domain.Client;
import com.softserve.edu.domain.Visa;

@Repository
@Transactional
public class VisaDaoImpl extends GenericDaoImpl<Visa> implements VisaDao {

    @SuppressWarnings("unchecked")
    public Set<Visa> find(String firstName, String lastName) {
        Set<Visa> visas = null;
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Client where firstName =:fName and lastName =:lName");
        query.setParameter("fName", firstName);
        query.setParameter("lName", lastName);
        List<Client> list = query.list();
        if (list.size() > 0)
            visas = list.get(0).getVisas();
        return visas;
    }

    @SuppressWarnings("rawtypes")
    public int countOfVisas(String country) {
        int count = 0;
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select count(country.id) from Visa  where country.name =:country");
        query.setParameter("country", country);
        List list = query.list();
        count = ((Number) list.get(0)).intValue();
        return count;
    }

    @SuppressWarnings("unchecked")
    public List<Visa> findValid(String firstName, String lastName, String country) {
        List<Visa> list = null;
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select v from Client as c join c.visas v "
                        + "where c.firstName = :fName and lastName = :lName "
                        + " and v.endDate > CURRENT_DATE() and v.country.name= :country");
        query.setParameter("fName", firstName);
        query.setParameter("lName", lastName);
        query.setParameter("country", country);
        list = query.list();
        return list;
    }
}
