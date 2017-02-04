package com.softserve.edu.dao;

import java.util.List;

public interface GenericDao<E> {

    public void add(E element);

    public void update(E element);

    public E getById(Integer id);

    public List<E> getAllElements();

    public void delete(E element);
}
