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

    /**
     * Deletes a todo by id if it's the given user's.
     * @param todoId the todo's id to remove
     * @param userName the username
     * @return true if succeeded, otherwise false
     */
    boolean deleteTodoById(Long todoId, String userName);
}
