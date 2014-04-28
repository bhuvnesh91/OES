package com.bebo.oes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bebo.oes.dao.CandidateDao;
import com.bebo.oes.model.Candidate;
import com.bebo.oes.service.CandidateService;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {
	@Autowired
	private CandidateDao candidateDao;

	@Override
	public List<Candidate> getAllCandidates() {
		return candidateDao.getAllCandidates();
	}

	@Override
	public Candidate getCandidateById(int id) {
		return candidateDao.findById(id);
	}

	public void saveCandidate(Candidate candidate) {
		candidateDao.saveOrUpdate(candidate);
	}

	public void removeCandidate(Candidate candidate) {
		candidateDao.delete(candidate);
	}

}
