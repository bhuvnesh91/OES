package com.bebo.oes.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bebo.oes.dao.CandidateDao;
import com.bebo.oes.model.Candidate;

@Repository
@Transactional
public class CandidateDoaImpl extends AbstractDaoImpl<Candidate, Integer> implements CandidateDao {
	protected CandidateDoaImpl() {
		super(Candidate.class);
	}

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Candidate> getAllCandidates() {
		return sessionFactory.getCurrentSession().createQuery("From Candidate").list();
	}

}
