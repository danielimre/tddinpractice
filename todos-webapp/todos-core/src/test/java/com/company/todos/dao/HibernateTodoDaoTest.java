package com.company.todos.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.company.todos.domain.Todo;

/**
 * Unit test for {@link HibernateTodoDao}.
 *
 * @author Daniel Imre
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class HibernateTodoDaoTest {
    private final HibernateTodoDao dao = new HibernateTodoDao();

    @Mock
    private SessionFactory sessionFactory;

    @Before
    public void initDao() {
        dao.setSessionFactory(sessionFactory);
    }

    @Test
    public void shouldReturnAllTodos() {
        Session session = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        Query query = mock(Query.class);
        when(session.createQuery("from Todo")).thenReturn(query);
        List<Todo> todos = Arrays.asList(aTodo());
        when(query.list()).thenReturn(todos);
        List<Todo> result = dao.getAll();
        assertEquals(todos, result);
    }

    @Test
    public void shouldSaveOrUpdateOnSave() {
        Session session = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        Todo todo = aTodo();
        dao.save(todo);
        verify(session).saveOrUpdate(todo);
    }

    private Todo aTodo() {
        Todo todo = new Todo();
        todo.setId(1L);
        todo.setTitle("some title");
        return todo;
    }

}
