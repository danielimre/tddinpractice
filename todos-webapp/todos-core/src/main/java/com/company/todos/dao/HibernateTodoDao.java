package com.company.todos.dao;

import java.util.List;

import org.hibernate.SessionFactory;

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
    public List<Todo> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Todo")
                .list();
    }

    @Override
    public void save(Todo todo) {
        sessionFactory.getCurrentSession().saveOrUpdate(todo);
    }

    @Override
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Todo").executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
