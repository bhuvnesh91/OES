package com.bebo.oes.service;

import java.util.List;

import com.bebo.oes.model.Question;

public interface QuestionService {

	List<Question> getAllQuestions();

	void saveQuestion(Question question);

}
