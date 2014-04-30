package com.bebo.oes.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bebo.oes.dao.DepartmentDao;
import com.bebo.oes.model.Department;
@Repository
@Transactional
public class DepartmentDaoImpl implements DepartmentDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Department getDepartmentByName(String dept) {
		return (Department) sessionFactory.getCurrentSession().createQuery("from Department where lower(name) = :deptName").setParameter("deptName", dept.toLowerCase()).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getAllDepartments() {
		return sessionFactory.getCurrentSession().createQuery("From Department").list();
	}

}
