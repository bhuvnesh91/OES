/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bebo.oes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author bbansal
 */
@Controller
public class WelcomeController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
}
