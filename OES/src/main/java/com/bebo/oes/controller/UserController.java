package com.bebo.oes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bebo.oes.model.Candidate;
import com.bebo.oes.service.CandidateService;

@Controller
public class UserController {

	@Autowired
	private CandidateService candidateService;

	@RequestMapping(value = "/candidates", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Candidate> getUsers() {
		List<Candidate> candidateList = null;
		candidateList = candidateService.getAllCandidates();
		return candidateList;
	}

	@RequestMapping(value = "/candidates/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Candidate getUser(@PathVariable("id") int id) {
		Candidate candidate = candidateService.getCandidateById(id);
		return candidate;
	}

	@RequestMapping(value = "/candidates", method = RequestMethod.POST)
	@ResponseBody
	public void saveUser(@RequestBody Candidate candidate,HttpServletRequest request) {
		Candidate candidate2 = new Candidate();
		candidate2.setEmailId(candidate.getEmailId());
		candidate2.setFirstName(candidate.getFirstName());
		candidate2.setPhoneNumber(candidate.getPhoneNumber());
		candidateService.saveCandidate(candidate2);
	}

	@RequestMapping(value = "/candidates/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateUser(@RequestBody Candidate candidate, @PathVariable("id") int id) {
		Candidate oldCandidate = candidateService.getCandidateById(id);
		oldCandidate.setEmailId(candidate.getEmailId());
		oldCandidate.setFirstName(candidate.getFirstName());
		oldCandidate.setPhoneNumber(candidate.getPhoneNumber());
		candidateService.saveCandidate(oldCandidate);
	}

	@RequestMapping(value = "/candidates/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void remove(@PathVariable int id) {
		Candidate candidate = candidateService.getCandidateById(id);
		candidateService.removeCandidate(candidate);
	}
}
