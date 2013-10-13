package com.company.todos.dao;

import java.util.List;

import com.company.todos.domain.Todo;

/**
 * {@link Todo} related data access methods.
 *
 * @author Mate Szvoboda
 *
 */
public interface TodoDao {

    /**
     * Gets all todo entries for a user.
     * @param userName the username
     * @return list of todos
     */
    List<Todo> getAllForUser(String userName);

    /**
     * Saves a todo entry.
     * @param todo todo entry to save
     */
    void save(Todo todo);

    /**
     * Removes all todos for a specific user.
     * @param userName the username
     */
    void removeAllForUser(String userName);

    /**
     * Gets a todo by id.
     * @param todoId the todo's id
     * @return the fetched todo if exists, otherwise null
     */
    Todo getById(long todoId);

    /**
     * Deletes a todo.
     * @param todo the todo to remove
     */
    void delete(Todo todo);

}
