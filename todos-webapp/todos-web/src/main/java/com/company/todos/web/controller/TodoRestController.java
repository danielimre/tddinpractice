package com.company.todos.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.todos.domain.Todo;
import com.company.todos.service.TodoService;

/**
 * Controller for all todo related RESTful requests.
 *
 * @author Mate Szvoboda
 *
 */
@Controller
@RequestMapping("/api/todo")
public class TodoRestController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Todo save(@RequestBody Todo todo) {
        todoService.save(todo);
        return todo;
    }

    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }
}
