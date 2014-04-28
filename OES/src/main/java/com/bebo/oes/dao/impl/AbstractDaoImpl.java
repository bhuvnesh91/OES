package com.bebo.oes.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;

import com.bebo.oes.dao.AbstractDao;

public class AbstractDaoImpl<E, I extends Serializable> implements
        AbstractDao<E, I> {

    private Class<E> entityClass;

    protected AbstractDaoImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
	@Override
    public E findById(I id) {
        return (E) getCurrentSession().get(entityClass, id);
    }

    @Override
    public void saveOrUpdate(E e) {
        getCurrentSession().saveOrUpdate(e);
    }

    @Override
    public void delete(E e) {
        getCurrentSession().delete(e);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<E> findByCriteria(Criterion criterion) {
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.add(criterion);
        return criteria.list();
    }

    @Override
    public void merge(E e) {
        getCurrentSession().merge(e);
    }
}
