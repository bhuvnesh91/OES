package com.bebo.oes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bebo.oes.model.Department;
import com.bebo.oes.model.Option;
import com.bebo.oes.model.Question;
import com.bebo.oes.model.QuestionDetails;
import com.bebo.oes.service.DepartmentService;
import com.bebo.oes.service.QuestionService;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/questions", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Question> getOptions() {
		List<Question> questionList = null;
		questionList = questionService.getAllQuestions();
		return questionList;
	}

	@RequestMapping(value = "/questions", method = RequestMethod.POST)
	@ResponseBody
	public void saveUser(@RequestBody QuestionDetails questionDetails) {
		List<Option> options = new ArrayList<Option>();
		Option option1 = new Option();
		option1.setName(questionDetails.getName1());
		option1.setValue(questionDetails.isValue1());
		Option option2 = new Option();
		option2.setName(questionDetails.getName2());
		option2.setValue(questionDetails.isValue2());
		Option option3 = new Option();
		option3.setName(questionDetails.getName3());
		option3.setValue(questionDetails.isValue3());
		Option option4 = new Option();
		option4.setName(questionDetails.getName4());
		option4.setValue(questionDetails.isValue4());
		options.add(option1);
		options.add(option2);
		options.add(option3);
		options.add(option4);
		Question question  =new Question();
		question.setOptionList(options);
		question.setQuestionDesc(questionDetails.getQuestionDesc());
		Department department = departmentService.getDepartmentByName(questionDetails.getDept());
		question.setDepartment(department);
		questionService.saveQuestion(question);
	}

}
