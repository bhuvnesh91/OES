package com.bebo.oes.service;

import java.util.List;

import com.bebo.oes.model.Candidate;

public interface CandidateService {
	public List<Candidate> getAllCandidates();

	public Candidate getCandidateById(int id);

	public void saveCandidate(Candidate candidate);

	public void removeCandidate(Candidate candidate);
}
