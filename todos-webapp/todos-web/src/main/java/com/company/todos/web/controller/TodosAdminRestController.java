package com.company.todos.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.todos.domain.Todo;
import com.company.todos.service.TodoService;

/**
 * Super secret admin rest API for todos to help e2e testing.
 *
 * @author Daniel Imre
 *
 */
@Controller
public class TodosAdminRestController {

    @Autowired
    private TodoService todoService;

    /**
     * Removes all todos from database for a given user.
     */
    @RequestMapping(value = "/admin/api/todos/{userName}/purge", method = RequestMethod.GET)
    @ResponseBody
    public void removeAllForUser(@PathVariable String userName) {
        todoService.removeAllTodosForUser(userName);
    }

    /**
     * Adds a todo for a specific user.
     */
    @RequestMapping(value = "/admin/api/todos/{userName}/add", params = { "text", "completed" }, method = RequestMethod.GET)
    @ResponseBody
    public void addTodoForUser(@PathVariable String userName, @RequestParam String text, @RequestParam Boolean completed) {
        Todo todo = new Todo();
        todo.setTitle(text);
        todo.setCompleted(completed);
        todo.setUserName(userName);
        todoService.saveTodo(todo);
    }

    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }
}
