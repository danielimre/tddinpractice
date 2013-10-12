package com.company.todos.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/api/todos/{userName}")
public class TodoRestController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Todo> getAllForUser(@PathVariable String userName) {
        return todoService.getAllTodosForUser(userName);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Todo saveTodoForUser(@RequestBody Todo todo, @PathVariable String userName) {
        todo.setUserName(userName);
        todoService.saveTodo(todo);
        return todo;
    }

    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }
}
