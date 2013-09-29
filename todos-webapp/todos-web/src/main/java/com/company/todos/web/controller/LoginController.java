package com.company.todos.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.todos.web.controller.form.LoginForm;

/**
 * Controller for user login.
 * @author Daniel Imre
 *
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute LoginForm login) {
        return "redirect:/todos/" + login.getUsername() + "/";
    }
}
