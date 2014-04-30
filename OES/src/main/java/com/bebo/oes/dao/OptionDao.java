package com.bebo.oes.dao;

import java.util.List;

import com.bebo.oes.model.Option;

public interface OptionDao {

	void saveAllOptions(List<Option> options);

}
