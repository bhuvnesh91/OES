package com.bebo.oes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bebo.oes.dao.QuestionDao;
import com.bebo.oes.model.Question;
import com.bebo.oes.service.QuestionService;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDao questionDao;

	@Override
	public List<Question> getAllQuestions() {
		return questionDao.getAllQuestions();
	}

	@Override
	public void saveQuestion(Question question) {
		questionDao.saveOrUpdate(question);
	}
}
