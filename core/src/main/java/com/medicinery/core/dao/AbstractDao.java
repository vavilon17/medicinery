package com.medicinery.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<T> implements BasicDao<T>{

    private Class<T> entityClass;

    @Autowired
    private SessionFactory sessionFactory;

    public AbstractDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    protected Session currentSession() {
        return getSessionFactory().getCurrentSession();
    }

    public T findById(Long id) {
        return (T) currentSession().get(entityClass, id);
    }

    public List<T> findAll() {
        return (List<T>) currentSession().createCriteria(entityClass).list();
    }

    public T save(T item) {
        return (T) currentSession().save(item);
    }

    public void update(T item) {
        currentSession().update(item);
    }

    public void delete(T item) {
        currentSession().delete(item);
    }
}
