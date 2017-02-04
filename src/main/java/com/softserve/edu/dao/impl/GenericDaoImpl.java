package com.softserve.edu.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softserve.edu.dao.GenericDao;

@Repository
@Transactional
public class GenericDaoImpl<E> implements GenericDao<E> {

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<E> genericClass;

    public GenericDaoImpl() {

    }

    public GenericDaoImpl(Class<E> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    public void add(E element) {
        sessionFactory.getCurrentSession().save(element);

    }

    @Override
    public void update(E element) {
        sessionFactory.getCurrentSession().update(element);

    }

    @SuppressWarnings("unchecked")
    @Override
    public E getById(Integer id) {
        // TODO Auto-generated method stub
        return (E) sessionFactory.getCurrentSession().get(genericClass, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> getAllElements() {
        // TODO Auto-generated method stub
        return sessionFactory.getCurrentSession().createCriteria(genericClass).list();
    }

    @Override
    public void delete(E element) {
        sessionFactory.getCurrentSession().delete(element);

    }

}
