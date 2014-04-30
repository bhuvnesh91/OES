package com.bebo.oes.service;

import java.util.List;

import com.bebo.oes.model.Department;

public interface DepartmentService {

	Department getDepartmentByName(String dept);

	List<Department> getAllDepartments();

}
