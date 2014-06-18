/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bebo.oes.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bebo.oes.dao.UserDao;
import com.bebo.oes.model.UserLogin;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDaoImpl<UserLogin, String> implements UserDao, UserDetailsService {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDaoImpl() {
		super(UserLogin.class);
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		UserLogin users = (UserLogin) sessionFactory.getCurrentSession().createQuery("from UserLogin where userName=:username").setString("username", username).uniqueResult();
		return (UserDetails) users;
	}

}
