package com.bebo.oes.dao;

import java.util.List;

import com.bebo.oes.model.Department;

public interface DepartmentDao {

	Department getDepartmentByName(String dept);

	List<Department> getAllDepartments();

}
