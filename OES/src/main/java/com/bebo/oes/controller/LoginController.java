package com.bebo.oes.controller;

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
}