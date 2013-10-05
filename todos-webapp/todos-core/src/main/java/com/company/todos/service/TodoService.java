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
     * Gets all stored todo entries.
     * @return stored todo entries
     */
    List<Todo> getAll();

    /**
     * Saves (updates or creates) the given todo entry.
     * @param todo entry to save
     */
    void save(Todo todo);
}
