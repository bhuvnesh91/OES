package com.bebo.oes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bebo.oes.dao.OptionDao;
import com.bebo.oes.model.Option;
import com.bebo.oes.service.OptionService;

@Service
@Transactional
public class OptionServiceIml implements OptionService {
	@Autowired
	private OptionDao optionDao;

	public void saveOptionAll(List<Option> options) {
		optionDao.saveAllOptions(options);
	}

}
