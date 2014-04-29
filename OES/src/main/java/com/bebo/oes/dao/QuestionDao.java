package com.bebo.oes.dao;

import java.util.List;

import com.bebo.oes.model.Question;

public interface QuestionDao extends AbstractDao<Question, Integer> {

	List<Question> getAllQuestions();

}
