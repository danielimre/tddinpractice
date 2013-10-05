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
     * Gets all todo entries.
     * @return list of todos
     */
    List<Todo> getAll();

    /**
     * Saves a todo entry.
     * @param todo todo entry to save
     */
    void save(Todo todo);
}
