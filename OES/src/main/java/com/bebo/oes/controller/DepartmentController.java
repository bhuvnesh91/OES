package com.bebo.oes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bebo.oes.model.Department;
import com.bebo.oes.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "/departments", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Department> getDepartments() {
		List<Department> departmentList = null;
		departmentList = departmentService.getAllDepartments();
		return departmentList;
	}
}
