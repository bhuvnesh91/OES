package com.bebo.oes.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bebo.oes.dao.OptionDao;
import com.bebo.oes.model.Option;

@Repository
@Transactional
public class OptionDaoImpl implements OptionDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveAllOptions(List<Option> options) {
		for (Option option : options) {
			sessionFactory.getCurrentSession().saveOrUpdate(option);
		}
	}
}
