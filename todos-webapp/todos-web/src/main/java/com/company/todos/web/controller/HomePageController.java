package com.company.todos.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.company.todos.web.controller.form.LoginForm;

/**
 * Controller for homepage.
 *
 * @author Daniel Imre
 */
@Controller
@RequestMapping("/")
public class HomePageController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome() {
        return new ModelAndView("index", "command", new LoginForm());
    }
}
