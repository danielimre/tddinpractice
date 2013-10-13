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
public class TodoRestController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/api/todos/{userName}", method = RequestMethod.GET)
    @ResponseBody
    public List<Todo> getAllForUser(@PathVariable String userName) {
        return todoService.getAllTodosForUser(userName);
    }

    @RequestMapping(value = "/api/todos/{userName}", method = RequestMethod.POST)
    @ResponseBody
    public Todo createTodoForUser(@RequestBody Todo todo, @PathVariable String userName) {
        todo.setUserName(userName);
        todoService.saveTodo(todo);
        return todo;
    }

    @RequestMapping(value = "/api/todos/{userName}/{todoId}", method = RequestMethod.POST)
    @ResponseBody
    public Todo updateTodoOfUser(@RequestBody Todo todo, @PathVariable Long todoId, @PathVariable String userName) {
        todo.setUserName(userName);
        todo.setId(todoId);
        todoService.saveTodo(todo);
        return todo;
    }

    @RequestMapping(value = "/api/todos/{userName}/{todoId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTodo(@PathVariable Long todoId, @PathVariable String userName) {
        if (!todoService.deleteTodoById(todoId, userName)) {
            throw new IllegalArgumentException();
        }
    }

    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }

}
