package com.company.todos.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.todos.service.TodoService;

/**
 * Super secret admin rest API for todos to help e2e testing.
 * @author Daniel Imre
 *
 */
@Controller
public class TodosAdminRestController {

    @Autowired
    private TodoService todoService;

    /**
     * Removes all todos from database.
     */
    @RequestMapping(value = "/admin/api/todo/purge", method = RequestMethod.GET)
    @ResponseBody
    public void removeAll() {
        todoService.removeAll();
    }

    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }
}
