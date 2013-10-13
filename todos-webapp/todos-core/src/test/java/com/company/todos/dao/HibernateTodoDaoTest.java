package com.company.todos.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
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
import com.company.todos.domain.Todo.TodoBuilder;

/**
 * Unit test for {@link HibernateTodoDao}.
 *
 * @author Daniel Imre
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class HibernateTodoDaoTest {
    private static final String USER_NAME = "user";
    private static final long TODO_ID = 1L;
    private final HibernateTodoDao dao = new HibernateTodoDao();

    @Mock
    private SessionFactory sessionFactory;

    @Before
    public void initDao() {
        dao.setSessionFactory(sessionFactory);
    }

    @Test
    public void shouldReturnAllTodosForUser() {
        Session session = stubSession();
        Query query = mock(Query.class);
        when(session.createQuery("from Todo where userName = :userName")).thenReturn(query);
        Query query2 = mock(Query.class);
        when(query.setParameter("userName", USER_NAME)).thenReturn(query2);
        List<Todo> todos = Arrays.asList(aTodo().build());
        when(query2.list()).thenReturn(todos);
        List<Todo> result = dao.getAllForUser(USER_NAME);
        assertEquals(todos, result);
    }

    @Test
    public void shouldSaveOrUpdateOnSave() {
        Session session = stubSession();
        Todo todo = aTodo().build();
        dao.save(todo);
        verify(session).saveOrUpdate(todo);
    }

    @Test
    public void shouldDeleteAllTodosForUser() {
        Session session = stubSession();
        Query query = mock(Query.class);
        when(session.createQuery("delete from Todo where userName = :userName")).thenReturn(query);
        Query query2 = mock(Query.class);
        when(query.setParameter("userName", USER_NAME)).thenReturn(query2);
        dao.removeAllForUser(USER_NAME);
        verify(query2).executeUpdate();
    }

    @Test
    public void shouldDeleteTodo() {
        Session session = stubSession();
        Todo todo = aTodo().build();
        dao.delete(todo);
        verify(session).delete(todo);
    }

    @Test
    public void shouldGetTodoById() {
        Session session = stubSession();
        Todo todo = aTodo().build();
        when(session.get(Todo.class, TODO_ID)).thenReturn(todo);
        Todo todoRetrieved = dao.getById(TODO_ID);
        assertSame(todo, todoRetrieved);
    }

    private Session stubSession() {
        Session session = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        return session;
    }

    private TodoBuilder aTodo() {
        return new TodoBuilder();
    }

}
