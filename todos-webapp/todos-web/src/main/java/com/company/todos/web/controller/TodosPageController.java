package com.company.todos.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.company.todos.web.util.HtmlUtils;

/**
 * Controller for todos page.
 *
 * @author Daniel Imre
 *
 */
@Controller
public class TodosPageController {

    @RequestMapping(value = "/todos/{username}/", method = RequestMethod.GET)
    public ModelAndView listTodosForUser(@PathVariable String username) {
        return new ModelAndView("todos", "username", HtmlUtils.stripTags(username));
    }

}
