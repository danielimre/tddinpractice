package com.company.todos.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.company.todos.dao.TodoDao;
import com.company.todos.domain.Todo;

/**
 * Default implementation of {@link TodoService}.
 * @author Mate Szvoboda
 *
 */
public class TodoServiceImpl implements TodoService {

    private TodoDao todoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Todo> getAll() {
        return todoDao.getAll();
    }

    @Override
    @Transactional
    public void save(Todo todo) {
        todoDao.save(todo);
    }

    @Override
    @Transactional
    public void removeAll() {
        todoDao.removeAll();
    }

    public void setTodoDao(TodoDao todoDao) {
        this.todoDao = todoDao;
    }
}
