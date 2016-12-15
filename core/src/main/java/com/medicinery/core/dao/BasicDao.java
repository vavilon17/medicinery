package com.medicinery.core.dao;

import java.util.List;

public interface BasicDao<T> {

    T findById(Long id);

    List<T> findAll();

    T save(T item);

    void update(T item);

    void delete(T item);
}
