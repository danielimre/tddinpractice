package com.company.todos.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.company.todos.domain.Todo;

/**
 * Hibernate based implementation of {@link TodoDao}.
 *
 * @author Mate Szvoboda
 *
 */
public class HibernateTodoDao implements TodoDao {

    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Todo> getAllForUser(String userName) {
        return getSession().createQuery("from Todo where userName = :userName").setParameter("userName", userName).list();
    }

    @Override
    public void save(Todo todo) {
        getSession().saveOrUpdate(todo);
    }

    @Override
    public void removeAllForUser(String userName) {
        getSession().createQuery("delete from Todo where userName = :userName").setParameter("userName", userName).executeUpdate();
    }

    @Override
    public void delete(Todo todo) {
        getSession().delete(todo);
    }

    @Override
    public Todo getById(long todoId) {
        return (Todo) getSession().get(Todo.class, todoId);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
