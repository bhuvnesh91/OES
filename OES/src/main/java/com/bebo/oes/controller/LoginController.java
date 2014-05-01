package com.bebo.oes.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "redirect:/login";
	}

	@RequestMapping(value = "/customlogin", method = RequestMethod.GET)
	public String customlogin() {
		boolean isAdmin = true;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authList = auth.getAuthorities();
		for (GrantedAuthority authority : authList) {
			if (authority.getAuthority().contains("ROLE_ADMIN")) {
				isAdmin = true;
			} else if (authority.getAuthority().contains("ROLE_CANDIDATE")) {
				isAdmin = false;
			}
		}
		if (isAdmin)
			return "redirect:/welcome";
		else
			return "redirect:/candidate";
	}
}