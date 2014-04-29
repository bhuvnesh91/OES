package com.bebo.oes.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bebo.oes.dao.QuestionDao;
import com.bebo.oes.model.Question;


@Repository
@Transactional
public class QuestionDaoImpl extends AbstractDaoImpl<Question, Integer> implements QuestionDao {
	protected QuestionDaoImpl() {
		super(Question.class);
	}

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Question> getAllQuestions() {
		return sessionFactory.getCurrentSession().createQuery("From Question").list();
	}

}
