package com.bebo.oes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bebo.oes.dao.DepartmentDao;
import com.bebo.oes.model.Department;
import com.bebo.oes.service.DepartmentService;



@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	public Department getDepartmentByName(String dept) {
		return departmentDao.getDepartmentByName(dept);
	}

	public List<Department> getAllDepartments() {
		return departmentDao.getAllDepartments();
	}

}
