package com.bebo.oes.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bebo.oes.dao.QuestionDao;
import com.bebo.oes.model.Department;
import com.bebo.oes.model.Option;
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

	public void saveAllQuestions(String filename, Department department) {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		try {

			br = new BufferedReader(new FileReader(filename));
			while ((line = br.readLine()) != null) {
				String[] data = line.split(cvsSplitBy);
				List<Option> options = new ArrayList<Option>();
				Question question = new Question();
				question.setQuestionDesc(data[0]);
				question.setDepartment(department);
				Option option1 = new Option();
				option1.setName(data[1]);
				option1.setQuestion(question);
				option1.setValue((data[5].equalsIgnoreCase("1")) ? true : false);
				option1.setValue(false);
				Option option2 = new Option();
				option2.setName(data[2]);
				option2.setQuestion(question);
				option2.setValue((data[6].equalsIgnoreCase("1")) ? true : false);
				Option option3 = new Option();
				option3.setName(data[3]);
				option3.setQuestion(question);
				option3.setValue((data[7].equalsIgnoreCase("1")) ? true : false);
				Option option4 = new Option();
				option4.setName(data[4]);
				option4.setQuestion(question);
				option4.setValue((data[8].equalsIgnoreCase("1")) ? true : false);
				options.add(option1);
				options.add(option2);
				options.add(option3);
				options.add(option4);
				question.setOptionList(options);
				questionDao.saveOrUpdate(question);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public Question getQuestion() {
		Question question = null;
		int maxId = questionDao.getMaxId();
		while (question == null) {
			question = getQuestionData(maxId);
		}
		return question;
	}

	// to get Question from Database
	public Question getQuestionData(int maxId) {
		int id = 1 + (int) (Math.random() * maxId);
		return questionDao.findById(id);
	}

}
