/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bebo.oes.service;

import com.bebo.oes.model.UserLogin;

/**
 * 
 * @author akathpal
 */
public interface UserService {

	public UserLogin getUserByUserName(String userName);
}
