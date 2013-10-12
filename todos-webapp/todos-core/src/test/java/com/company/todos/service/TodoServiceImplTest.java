package com.company.todos.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.company.todos.dao.TodoDao;
import com.company.todos.domain.Todo;
import com.company.todos.domain.Todo.TodoBuilder;

/**
 * Unit test of {@link TodoServiceImpl}.
 *
 * @author Mate Szvoboda
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TodoServiceImplTest {
    private static final String USER_NAME = "user";

    @Mock
    private TodoDao todoDao;

    private TodoServiceImpl todoServiceImpl;

    @Before
    public void setup() {
        todoServiceImpl = new TodoServiceImpl();
        todoServiceImpl.setTodoDao(todoDao);
    }

    @Test
    public void testIfReturnsAllTodosForUser() {
        List<Todo> todos = Arrays.asList(aTodo().withId(1L).withTitle("Milk").build(), aTodo().withId(2L).withTitle("Sugar").build());
        when(todoDao.getAllForUser(USER_NAME)).thenReturn(todos);
        List<Todo> result = todoServiceImpl.getAllTodosForUser(USER_NAME);
        assertThat(result, equalTo(todos));
    }

    @Test
    public void testThatDaoIsCalledWhenTodoGetsSaved() {
        Todo todo = aTodo().withId(1L).withTitle("Milk").build();
        todoServiceImpl.saveTodo(todo);
        verify(todoDao).save(Mockito.eq(todo));
    }

    @Test
    public void shouldRemoveAllTodosForUser() {
        todoServiceImpl.removeAllTodosForUser(USER_NAME);
        verify(todoDao).removeAllForUser(USER_NAME);
    }

    private TodoBuilder aTodo() {
        return new TodoBuilder();
    }
}
