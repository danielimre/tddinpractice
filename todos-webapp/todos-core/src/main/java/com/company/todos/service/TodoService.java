package com.company.todos.service;

import java.util.List;

import com.company.todos.domain.Todo;

/**
 * Todo service.
 * @author Mate Szvoboda
 *
 */
public interface TodoService {

    /**
     * Gets all stored todo entries for a user.
     * @param userName the username
     * @return stored todo entries
     */
    List<Todo> getAllTodosForUser(String userName);

    /**
     * Saves (updates or creates) the given todo entry.
     * @param todo entry to save
     */
    void saveTodo(Todo todo);

    /**
     * Removes all todos for a given user.
     * @param userName the username
     */
    void removeAllTodosForUser(String userName);
}
