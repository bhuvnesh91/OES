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
import com.bebo.oes.model.QuestionFile;
import com.bebo.oes.service.DepartmentService;
import com.bebo.oes.service.OptionService;
import com.bebo.oes.service.QuestionService;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private OptionService optionService;

	@RequestMapping(value = "/questions", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Question> getQuestions() {
		List<Question> questionList = null;
		questionList = questionService.getAllQuestions();
		return questionList;
	}

	@RequestMapping(value = "/questions", method = RequestMethod.POST)
	@ResponseBody
	public void saveQuestion(@RequestBody QuestionDetails questionDetails) {
		List<Option> options = new ArrayList<Option>();
		Question question = new Question();
		question.setQuestionDesc(questionDetails.getQuestionDesc());
		Department department = departmentService.getDepartmentByName(questionDetails.getDept());
		question.setDepartment(department);
		Option option1 = new Option();
		option1.setName(questionDetails.getName1());
		option1.setQuestion(question);
		if (questionDetails.getValue1().equalsIgnoreCase("true"))
			option1.setValue(true);
		else
			option1.setValue(false);
		Option option2 = new Option();
		option2.setName(questionDetails.getName2());
		option2.setQuestion(question);
		if (questionDetails.getValue2().equalsIgnoreCase("true"))
			option2.setValue(true);
		else
			option2.setValue(false);
		Option option3 = new Option();
		option3.setName(questionDetails.getName3());
		option3.setQuestion(question);
		if (questionDetails.getValue3().equalsIgnoreCase("true"))
			option3.setValue(true);
		else
			option3.setValue(false);
		Option option4 = new Option();
		option4.setName(questionDetails.getName4());
		option4.setQuestion(question);
		if (questionDetails.getValue4().equalsIgnoreCase("true"))
			option4.setValue(true);
		else
			option4.setValue(false);
		options.add(option1);
		options.add(option2);
		options.add(option3);
		options.add(option4);
		question.setOptionList(options);
		optionService.saveOptionAll(options);
	}
	
	@RequestMapping(value = "/questionfile", method = RequestMethod.POST)
	@ResponseBody
	public void saveQuestions(@RequestBody QuestionFile questionFile) {
		System.out.println("dsjk");
	}

}
