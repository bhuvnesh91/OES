/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bebo.oes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bebo.oes.dao.UserDao;
import com.bebo.oes.model.UserLogin;
import com.bebo.oes.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("UserDaoImpl")
	private UserDao userDao;

	public UserLogin getUserByUserName(String userName) {
		return null;
	}

}
