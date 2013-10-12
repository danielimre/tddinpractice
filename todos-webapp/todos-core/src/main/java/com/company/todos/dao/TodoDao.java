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
}
