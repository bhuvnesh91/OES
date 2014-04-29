package com.bebo.oes.dao;

import java.util.List;

import com.bebo.oes.model.Candidate;

public interface CandidateDao extends AbstractDao<Candidate, Integer>{

	public List<Candidate> getAllCandidates();

}
