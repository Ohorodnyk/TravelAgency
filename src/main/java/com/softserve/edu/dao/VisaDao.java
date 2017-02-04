package com.softserve.edu.dao;

import java.util.List;
import java.util.Set;

import com.softserve.edu.domain.Visa;

public interface VisaDao extends GenericDao<Visa> {

    public abstract Set<Visa> find(String firstName, String lastName);

    public abstract int countOfVisas(String country);

    public abstract List<Visa> findValid(String firstName, String lastName, String country);

}
